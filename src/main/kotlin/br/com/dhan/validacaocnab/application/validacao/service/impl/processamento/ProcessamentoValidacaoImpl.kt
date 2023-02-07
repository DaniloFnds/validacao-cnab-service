package br.com.dhan.validacaocnab.application.validacao.service.impl.processamento

import br.com.dhan.validacaocnab.application.layout.LayoutDiscoverHandler
import br.com.dhan.validacaocnab.application.layout.usecase.LayoutRetrieveUseCase
import br.com.dhan.validacaocnab.application.registro.port.RegistroCnabPort
import br.com.dhan.validacaocnab.application.validacao.service.BeanReaderDiscover
import br.com.dhan.validacaocnab.application.validacao.service.ProcessamentoValidacao
import br.com.dhan.validacaocnab.application.validacao.service.ResolverValidadores
import br.com.dhan.validacaocnab.commons.extensions.toEntity
import br.com.dhan.validacaocnab.domain.cnab.Cnab
import br.com.dhan.validacaocnab.domain.registro.RegistroCnab
import br.com.dhan.validacaocnab.infra.adapters.registro.jpa.entity.RegistroCnabEntity
import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.concurrent.atomic.AtomicInteger
import kotlin.reflect.full.isSuperclassOf

@Service
class ProcessamentoValidacaoImpl(
    private val beanReaderDiscover: BeanReaderDiscover,
    private val resolverValidadores: ResolverValidadores,
    private val registroCnabPort: RegistroCnabPort,
    private val layoutDiscoverHandler: LayoutDiscoverHandler,
    private val meterRegistry: MeterRegistry
) : ProcessamentoValidacao {

    override fun processar(cnab: Cnab) =
        runBlocking(Dispatchers.IO) {
            cnab.file.use { readerFile ->
                val layout =
                    layoutDiscoverHandler.handler(LayoutRetrieveUseCase(cnab))

                val createReader = async {
                    beanReaderDiscover.discover(layout, readerFile)
                }

                val listValidacoesDeRegistro = async {
                    resolverValidadores.resolveValidacoesDoRegistro(layout)
                }

                val registroInvalido = AtomicInteger(0)
                val registroValido = AtomicInteger(0)
                val totalRegistros = AtomicInteger(0)
                val registros = mutableListOf<RegistroCnabEntity>()

                // todo colocar para pegar os registros invalidos qd estiver fora da estrutura do layout
                // o handler do bean io, verificar se é possível sempre q acontecer erro de estrutura, devolver o campo
                // para que possamos colocar ( talvez trazer aquele codigo q encontra o campo

                runCatching {
                    // todo colocar log
                    while (true) {
                        val registro = createReader.await().read() as? RegistroCnab
                        registro?.let {
                            registro.idCnab = cnab.id
                            val validacoesDeRegistro = listValidacoesDeRegistro.await().filter {
                                it.registro().isSuperclassOf(registro::class)
                            }

                            val registrosValidados =
                                ValidatorExecuter(
                                    resolverValidadores.resolveValidadorDeLayout(registro),
                                    validacoesDeRegistro
                                ).executa(registro)

                            totalRegistros.incrementAndGet()
                            if (registrosValidados.isEmpty()) {
                                registroValido.incrementAndGet()
                            } else {
                                registroInvalido.incrementAndGet()
                            }

                            meterRegistry.counter(
                                "validacao_cnab",
                                listOf(
                                    Tag.of("registro_cnab", "validado"),
                                    Tag.of("registro_cnab_validado_data", LocalDate.now().toString())
                                )
                            ).increment()
                            registros.add(registro.toEntity())
                        } ?: break
                    }
                    cnab
                }.onSuccess {
                    // todo colocar log de sucesso

                    registroCnabPort.create(registros)
                }.onFailure {
                }
            }.getOrDefault(cnab)
        }
}
