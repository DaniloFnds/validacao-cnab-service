package br.com.dhan.validacaocnab.application.validacao.service.impl.processamento

import br.com.dhan.validacaocnab.application.registro.port.RegistroCnabPort
import br.com.dhan.validacaocnab.application.validacao.service.ProcessamentoValidacao
import br.com.dhan.validacaocnab.application.validacao.service.ResolverColetorDados
import br.com.dhan.validacaocnab.application.validacao.service.ResolverValidadores
import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.model.RetornoValidacao
import br.com.dhan.validacaocnab.commons.extensions.toEntity
import br.com.dhan.validacaocnab.domain.cnab.Cnab
import br.com.dhan.validacaocnab.domain.layout.Layout
import br.com.dhan.validacaocnab.domain.registro.ArquivoCnab
import br.com.dhan.validacaocnab.domain.registro.RegistroCnab
import br.com.dhan.validacaocnab.infra.adapters.registro.jpa.entity.RegistroCnabEntity
import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.beanio.StreamFactory
import org.springframework.stereotype.Service
import java.nio.charset.Charset
import java.time.LocalDate
import java.util.concurrent.atomic.AtomicInteger
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@Service
class ProcessamentoValidacaoImpl(
    private val streamFactory: StreamFactory,
    private val resolverColetorDados: ResolverColetorDados,
    private val resolverValidadores: ResolverValidadores,
    private val registroCnabPort: RegistroCnabPort,
    private val meterRegistry: MeterRegistry
) : ProcessamentoValidacao {

    @OptIn(ExperimentalTime::class)
    override suspend fun processar(layout: Layout, cnab: Cnab): ArquivoCnab {
        return runBlocking(Dispatchers.Default) {
            println("processando arquivo: ${cnab.nome}")
            val createReader = async { streamFactory.createReader(layout.stream, cnab.inputFile.reader(Charset.defaultCharset())) }
            val coletorDados = async { resolverColetorDados.resolve(layout).coletar() }

            val atomicInvalido = AtomicInteger(0)
            val atomicValido = AtomicInteger(0)
            val atomicTotalRegistros = AtomicInteger(0)
            val registrosValidados: MutableSet<RetornoValidacao> = mutableSetOf()
            val registros = mutableListOf<RegistroCnabEntity>()
            measureTime {
                while (true) {
                    val registro = createReader.await().read() as? RegistroCnab ?: break
                    registro.coletorDados = coletorDados.await()
                    registro.idArquivo = cnab.id

                    registrosValidados.addAll(resolverValidadores.resolverAndExecute(layout, registro))
                    atomicTotalRegistros.incrementAndGet()
                    if (registrosValidados.isEmpty()) {
                        atomicValido.incrementAndGet()
                    } else {
                        atomicInvalido.incrementAndGet()
                    }
                    meterRegistry.counter("registroCnabCriado", listOf(Tag.of("registroCnab", "created"), Tag.of("registroCnabTime", LocalDate.now().toString())))
                        .increment()
                    registros.add(registro.toEntity())
                }
                registroCnabPort.create(registros)
            }.also {
                println("Tempo validando: ${it.absoluteValue} - ${it.inWholeMilliseconds} - ${it.inWholeNanoseconds}")
            }

            ArquivoCnab(
                idArquivo = cnab.id,
                idFundo = cnab.idFundo,
                nome = cnab.nome,
                totalInvalidos = atomicInvalido.get(),
                totalValidos = atomicValido.get(),
                totalRegistros = atomicTotalRegistros.get()
            )
        }
    }
}
