package br.com.dhan.geraroperacao.application.validacao.service

import br.com.dhan.geraroperacao.commons.exceptions.LayoutNotFoundException
import br.com.dhan.geraroperacao.domain.layout.Layout
import br.com.dhan.geraroperacao.domain.layout.layoutPorCodigo

class ResolverColetorDados(
    private val layout: Layout,
    private val listColetorDados: List<ColetorDados>
) {

    fun resolve(layout: Layout): ColetorDados {
        return listColetorDados.find {
            it.layout().contains(layout.layoutPorCodigo())
        } ?: throw LayoutNotFoundException("can not resolve layout by codigo")
    }
}
