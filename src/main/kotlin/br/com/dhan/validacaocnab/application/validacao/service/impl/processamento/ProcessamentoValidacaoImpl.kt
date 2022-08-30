package br.com.dhan.validacaocnab.application.validacao.service.impl.processamento

import br.com.dhan.validacaocnab.application.registro.port.RegistroCnabEventPort
import br.com.dhan.validacaocnab.domain.registro.ArquivoCnab
import br.com.dhan.validacaocnab.application.validacao.service.ProcessamentoValidacao
import br.com.dhan.validacaocnab.application.validacao.service.ResolverColetorDados
import br.com.dhan.validacaocnab.application.validacao.service.ResolverValidadores
import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.model.RetornoValidacao
import br.com.dhan.validacaocnab.domain.cnab.Cnab
import br.com.dhan.validacaocnab.domain.layout.Layout
import br.com.dhan.validacaocnab.domain.registro.RegistroCnab
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.beanio.StreamFactory
import org.springframework.stereotype.Service
import java.nio.charset.Charset
import java.util.concurrent.atomic.AtomicInteger

@Service
class ProcessamentoValidacaoImpl(
    private val streamFactory: StreamFactory,
    private val resolverColetorDados: ResolverColetorDados,
    private val resolverValidadores: ResolverValidadores,
    private val registroCnabEventPort: RegistroCnabEventPort
) : ProcessamentoValidacao {

    override fun processar(layout: Layout, cnab: Cnab): ArquivoCnab {
        return runBlocking(Dispatchers.Default) {
            val createReader = async { streamFactory.createReader(layout.stream, cnab.inputFile.reader(Charset.defaultCharset())) }
            val coletorDados = async { resolverColetorDados.resolve(layout).coletar() }

            val atomicInvalido = AtomicInteger(0)
            val atomicValido = AtomicInteger(0)
            val atomicTotalRegistros = AtomicInteger(0)
            val registrosValidados: MutableSet<RetornoValidacao> = mutableSetOf()
            while (true) {
                val registro = createReader.await().read() as? RegistroCnab ?: break
                registro.coletorDados = coletorDados.await()
                registro.idArquivo = cnab.idArquivo

                registrosValidados.addAll(resolverValidadores.resolverAndExecute(layout, registro))
                atomicTotalRegistros.incrementAndGet()
                if (registrosValidados.isEmpty()) {
                    atomicValido.incrementAndGet()
                } else {
                    atomicInvalido.incrementAndGet()
                }
                launch { registroCnabEventPort.create(registro) }
            }

            ArquivoCnab(
                idArquivo = cnab.idArquivo,
                idFundo = cnab.idFundo,
                nome = cnab.nome,
                totalInvalidos = atomicInvalido.get(),
                totalValidos = atomicValido.get(),
                totalRegistros = atomicTotalRegistros.get()
            )
        }
    }
}
