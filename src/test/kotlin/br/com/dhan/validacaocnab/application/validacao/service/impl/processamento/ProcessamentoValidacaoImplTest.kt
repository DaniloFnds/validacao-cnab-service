/*
package br.com.dhan.validacaocnab.application.validacao.service.impl.processamento

import br.com.dhan.validacaocnab.application.registro.port.RegistroCnabPort
import br.com.dhan.validacaocnab.application.validacao.service.ColetorDados
import br.com.dhan.validacaocnab.application.validacao.service.ResolverColetorDados
import br.com.dhan.validacaocnab.application.validacao.service.ResolverValidadores
import br.com.dhan.validacaocnab.application.validacao.service.impl.coletor.model.SaidaColetor
import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.model.RetornoValidacao
import br.com.dhan.validacaocnab.domain.cnab.Cnab
import br.com.dhan.validacaocnab.domain.cnab.Layout
import br.com.dhan.validacaocnab.samples.RegistroCnabSample
import io.micrometer.core.instrument.MeterRegistry
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions
import org.beanio.BeanReader
import org.beanio.StreamFactory
import org.junit.jupiter.api.Test
import java.io.InputStreamReader

internal class ProcessamentoValidacaoImplTest {

    @Test
    fun `asd`() {
        val streamFactory = mockk<StreamFactory>()
        val beanReader = mockk<BeanReader>()
        every { beanReader.read() } returns RegistroCnabSample.createDetail() andThen null
        coEvery { streamFactory.createReader(any() as String, any() as InputStreamReader) } returns beanReader

        val layout = mockk<Layout>()
        every { layout.stream } returns "cnab400"
        every { layout.codigoLayout } returns "LAYOUT_400"
        val cnab: Cnab = mockk()
        every { cnab.inputFile } returns this.javaClass.classLoader.getResourceAsStream("cnabExample.xml")!!
        every { cnab.idArquivo } returns "138140931dd211b298fba9d536ec1204"
        every { cnab.idFundo } returns "64f57135099115cfa8b298174afe1c3b"
        every { cnab.nome } returns "civilize"

        val resolverColetorDados: ResolverColetorDados = mockk()
        val saidaColetor = object : SaidaColetor {}
        val coletorDados = mockk<ColetorDados<SaidaColetor>>()
        every { coletorDados.coletar() } returns saidaColetor
        every { resolverColetorDados.resolve(any()) } returns coletorDados

        val resolverValidadores: ResolverValidadores = mockk()
        coEvery { resolverValidadores.resolverAndExecute(any(), any()) } returns setOf(
            RetornoValidacao(
                RegistroCnabSample.createDetail(),
                "campo",
                "mensagem"
            )
        )
        val registroEventPort = mockk<RegistroCnabPort>()

        val processamentoValidacaoImpl = ProcessamentoValidacaoImpl(
            streamFactory,
            resolverColetorDados,
            resolverValidadores,
            registroEventPort,

        )

        val arquivoProcessado = processamentoValidacaoImpl.processar(layout, cnab)

        Assertions.assertThat(arquivoProcessado)
            .isNotNull
            .extracting("totalInvalidos").isEqualTo(1)
    }
}
*/
