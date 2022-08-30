package br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores

import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.model.RetornoValidacao
import br.com.dhan.validacaocnab.domain.layout.Layout
import br.com.dhan.validacaocnab.domain.layout.LayoutPorCodigoEnum
import br.com.dhan.validacaocnab.domain.registro.RegistroCnabDetail
import br.com.dhan.validacaocnab.domain.registro.RegistroCnabHeader
import br.com.dhan.validacaocnab.domain.registro.TipoRegistro
import br.com.dhan.validacaocnab.samples.RegistroCnabSample
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.reflect.KClass

internal class ResolverValidadoresImplTest {

    private val validadorDetail = object : Validador<RegistroCnabDetail> {
        override fun layout(): Set<LayoutPorCodigoEnum> {
            return setOf(LayoutPorCodigoEnum.LAYOUT_400)
        }

        override fun tipoRegistro(): KClass<RegistroCnabDetail> {
            return RegistroCnabDetail::class
        }

        override fun validar(registro: RegistroCnabDetail): Set<RetornoValidacao> {
            return setOf(
                RetornoValidacao(
                    RegistroCnabSample.createDetail(),
                    "teste",
                    "teste"
                )
            )
        }
    }

    private val validadorHeader = object : Validador<RegistroCnabHeader> {
        override fun layout(): Set<LayoutPorCodigoEnum> {
            return setOf(LayoutPorCodigoEnum.LAYOUT_400)
        }

        override fun tipoRegistro(): KClass<RegistroCnabHeader> {
            return RegistroCnabHeader::class
        }

        override fun validar(registro: RegistroCnabHeader): Set<RetornoValidacao> {
            return setOf(
                RetornoValidacao(
                    RegistroCnabSample.createHeader(),
                    "teste",
                    "teste"
                )
            )
        }
    }

    @Test
    fun `deve validar um registro header  `() {
        val listaValidadores = listOf<Validador<*>>(
            validadorDetail,
            validadorHeader
        )
        val resolver = ResolverValidadoresImpl(
            listValidadores = listaValidadores as List<Validador<TipoRegistro>>
        )

        val layout = Layout("cnab400RemessaPaulista", "cnab 400 remessa", "LAYOUT_400")

        val registroCnabHeader = RegistroCnabHeader()

        val resolved = resolver.resolverAndExecute(layout, registroCnabHeader)

        Assertions.assertThat(resolved)
            .isNotEmpty
            .hasSize(1)
            .extracting("campo")
            .contains("teste")
    }

    @Test
    fun `deve validar dois registro detail e header `() {
        val listaValidadores = listOf<Validador<*>>(
            validadorDetail,
            validadorHeader
        )
        val resolver = ResolverValidadoresImpl(
            listValidadores = listaValidadores as List<Validador<TipoRegistro>>
        )

        val layout = Layout("cnab400RemessaPaulista", "cnab 400 remessa", "LAYOUT_400")

        val registroCnabDetail = RegistroCnabDetail()
        val registroCnabHeader = RegistroCnabHeader()

        val listRetornos: MutableSet<in Any> = mutableSetOf()
        val resolvedHeader = resolver.resolverAndExecute(layout, registroCnabHeader)
        val resolvedDetail = resolver.resolverAndExecute(layout, registroCnabDetail)

        listRetornos.addAll(resolvedHeader.toMutableSet())
        listRetornos.addAll(resolvedDetail.toMutableSet())

        Assertions.assertThat(listRetornos)
            .isNotEmpty
            .hasSize(2)
            .extracting("campo")
            .contains("teste")
    }
}
