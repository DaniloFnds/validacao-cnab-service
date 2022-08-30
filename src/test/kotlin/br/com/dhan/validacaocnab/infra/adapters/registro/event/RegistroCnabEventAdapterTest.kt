package br.com.dhan.validacaocnab.infra.adapters.registro.event

import br.com.dhan.validacaocnab.infra.adapters.registro.event.publishers.RegistroCnabPublisher
import br.com.dhan.validacaocnab.samples.RegistroCnabSample
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class RegistroCnabEventAdapterTest {

    @Test
    fun `asda`() {
        val registroCnabPublisher = mockk<RegistroCnabPublisher>()
        every { registroCnabPublisher.sendMessage(any()) } just runs
        val registroCnabEventAdapter = RegistroCnabEventAdapter(
            registroCnabPublisher
        )

        val registroCnab = RegistroCnabSample.createDetail()
        val idRegistro = registroCnabEventAdapter.create(registroCnab)

        Assertions.assertThat(idRegistro)
            .isNotNull
    }
}
