package br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores.impl.cnab400

import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.model.RetornoValidacao
import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores.ValidacaoExecuter
import br.com.dhan.validacaocnab.domain.registro.Header
import br.com.dhan.validacaocnab.samples.RegistroCnabSample
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions
import org.assertj.core.groups.Tuple
import org.junit.jupiter.api.Test

internal class ValidadoresCnab400HeaderTest {

    @Test
    fun `deve validar um registro header `() {
        val registroHeader = RegistroCnabSample.createHeader()

        val validacaoHeader = mockk<ValidacaoExecuter<Header>>()
        every { validacaoHeader.campo(any()) } returns "campo"
        every { validacaoHeader.condicaoInvalido(any()) } returns true
        every { validacaoHeader.mensagemInvalido(any()) } returns "mensagem"
        every { validacaoHeader.validar(any()) } returns RetornoValidacao(registroHeader, "campo", "mensagem")

        val validadoresCnab400Header = ValidadoresCnab400Header(
            listOf(validacaoHeader)
        )

        val validado = validadoresCnab400Header.validar(registroHeader)

        Assertions.assertThat(validado)
            .isNotEmpty
            .hasSize(1)
            .extracting("campo")
            .contains("campo")

        verify(exactly = 1) { validacaoHeader.validar(any()) }
    }

    @Test
    fun `deve validar um registro header  e retorno null quando registro invalido`() {
        val registroHeader = RegistroCnabSample.createHeader()

        val validacaoHeader = mockk<ValidacaoExecuter<Header>>()
        every { validacaoHeader.campo(any()) } returns "campo"
        every { validacaoHeader.condicaoInvalido(any()) } returns false
        every { validacaoHeader.mensagemInvalido(any()) } returns "mensagem"
        every { validacaoHeader.validar(any()) } returns null

        val validadoresCnab400Header = ValidadoresCnab400Header(
            listOf(validacaoHeader)
        )

        val validado = validadoresCnab400Header.validar(registroHeader)

        Assertions.assertThat(validado)
            .isEmpty()

        verify(exactly = 1) { validacaoHeader.validar(any()) }
    }
}
