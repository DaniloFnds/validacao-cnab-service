package br.com.dhan.validacaocnab.application.validacao.service

import br.com.dhan.validacaocnab.commons.exceptions.LayoutNotFoundException
import br.com.dhan.validacaocnab.domain.layout.Layout
import br.com.dhan.validacaocnab.domain.layout.layoutPorCodigo
import org.springframework.stereotype.Service

@Service
class ResolverColetorDados(
    private val listColetorDados: List<ColetorDados<*>>
) {

    fun resolve(layout: Layout): ColetorDados<*> {
        return listColetorDados.find {
            it.layout().contains(layout.layoutPorCodigo())
        } ?: throw LayoutNotFoundException("can not resolve layout by codigo")
    }
}
