package br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores

import br.com.dhan.validacaocnab.application.validacao.service.ResolverValidadores
import br.com.dhan.validacaocnab.domain.cnab.Layout
import br.com.dhan.validacaocnab.domain.cnab.layoutPorCodigo
import br.com.dhan.validacaocnab.domain.registro.Detail
import br.com.dhan.validacaocnab.domain.registro.Header
import br.com.dhan.validacaocnab.domain.registro.Registro
import org.springframework.stereotype.Service

@Service
class ResolverValidadoresImpl(

    private val validadorDeHeader: ValidadorDeLayout<Header>,
    private val validadorDeDetail: ValidadorDeLayout<Detail>,
    private val listValidadoresDeRegistro: List<ValidadorDeRegistro<*>>
) : ResolverValidadores {

    @Suppress("UNCHECKED_CAST")
    override fun resolveValidacoesDoRegistro(layout: Layout): List<ValidadorDeRegistro<Registro>> {
        return listValidadoresDeRegistro.filter {
            it.layouts().contains(layout.layoutPorCodigo())
        } as List<ValidadorDeRegistro<Registro>>
    }

    override fun resolveValidadorDeLayout(registro: Registro): ValidadorDeLayout<Registro> {
        return when (registro) {
            is Detail -> validadorDeDetail
            is Header -> validadorDeHeader
        }
    }
}
