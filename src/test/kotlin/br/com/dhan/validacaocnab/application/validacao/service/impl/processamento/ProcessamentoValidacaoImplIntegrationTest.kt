package br.com.dhan.validacaocnab.application.validacao.service.impl.processamento

import br.com.dhan.validacaocnab.IntegrationConfigurationTest
import br.com.dhan.validacaocnab.application.layout.LayoutDiscoverHandler
import br.com.dhan.validacaocnab.application.layout.usecase.LayoutRetrieveUseCase
import br.com.dhan.validacaocnab.application.validacao.service.ProcessamentoValidacao
import br.com.dhan.validacaocnab.domain.cnab.Cnab
import br.com.dhan.validacaocnab.domain.cnab.Layout
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import java.io.InputStreamReader

@RunWith(SpringRunner::class)
class ProcessamentoValidacaoImplIntegrationTest : IntegrationConfigurationTest() {

    @Autowired
    private lateinit var processamentoValidacao: ProcessamentoValidacao

    @MockBean
    private lateinit var layoutDiscoverHandler: LayoutDiscoverHandler

    @Test
    fun teste() {
        // given
        val cnabStream = getFileFromResource("cnabs/CNAB_REMESSA_444_SUCESSO.txt")

        val cnab = Cnab(
            documentNumberFundo = "",
            name = "ARQUIVO (1).txt",
            file = InputStreamReader(cnabStream)
        )

        // and
        Mockito.`when`(
            layoutDiscoverHandler.handler(
                LayoutRetrieveUseCase(cnab)
            )
        ).thenReturn(Layout("cnab444RemessaPaulista", "Cnab 444", "LAYOUT_444"))

        val documentNumberFundo = processamentoValidacao.processar(
            cnab
        )

        println()
    }
}
