package br.com.dhan.validacaocnab.domain.cnab

import br.com.dhan.validacaocnab.domain.layout.LayoutPorCodigoEnum

data class Layout(
    val stream: String,
    val descricao: String,
    val codigoLayout: String
)

fun Layout.layoutPorCodigo(): LayoutPorCodigoEnum = LayoutPorCodigoEnum.valueOf(this.codigoLayout)
