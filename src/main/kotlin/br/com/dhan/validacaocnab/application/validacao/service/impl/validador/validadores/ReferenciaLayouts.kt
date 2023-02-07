package br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores

import br.com.dhan.validacaocnab.domain.layout.LayoutPorCodigoEnum

object ReferenciaLayouts {

    val LAYOUTS_TAMANHO_400 = arrayOf(
        LayoutPorCodigoEnum.LAYOUT_400_FINAXIS,
        LayoutPorCodigoEnum.LAYOUT_400_PAULISTA,
        LayoutPorCodigoEnum.LAYOUT_400_PAULISTA_V2,
        LayoutPorCodigoEnum.LAYOUT_400
    )

    val LAYOUTS_TAMANHO_444 = arrayOf(
        LayoutPorCodigoEnum.LAYOUT_444
    )
}
