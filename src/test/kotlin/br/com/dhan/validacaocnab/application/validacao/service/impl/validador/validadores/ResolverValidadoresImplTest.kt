package br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores

import br.com.dhan.validacaocnab.domain.layout.Layout
import br.com.dhan.validacaocnab.domain.layout.LayoutPorCodigoEnum
import br.com.dhan.validacaocnab.domain.registro.Detail
import br.com.dhan.validacaocnab.domain.registro.Header
import br.com.dhan.validacaocnab.domain.registro.RegistroCnabDetail
import br.com.dhan.validacaocnab.domain.registro.RegistroCnabHeader
import br.com.dhan.validacaocnab.domain.registro.TipoRegistro
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

internal class ResolverValidadoresImplTest {

    @Test
    fun resolver() {
        val validadorDetail = mockk<Validador<Detail>>()
        every { validadorDetail.layout() } returns setOf(LayoutPorCodigoEnum.LAYOUT_400)
        every { validadorDetail.tipoRegistro() } returns Detail::class

        val validadorHeader = mockk<Validador<Header>>()
        every { validadorHeader.layout() } returns setOf(LayoutPorCodigoEnum.LAYOUT_400)
        every { validadorHeader.tipoRegistro() } returns Header::class

        val listaValidadores = listOf<Validador<*>>(
            validadorDetail,
            validadorHeader
        )
        val resolver = ResolverValidadoresImpl(
            listValidadores = listaValidadores as List<Validador<TipoRegistro>>
        )

        val layout = Layout("cnab400RemessaPaulista", "cnab 400 remessa", "LAYOUT_400")
        val registroCnabDetail = RegistroCnabDetail().apply {

        }

        val registroCnabHeader = RegistroCnabHeader()

        val resolver1 = resolver.resolverAndExecute(layout, registroCnabHeader)

        println()
    }
}
