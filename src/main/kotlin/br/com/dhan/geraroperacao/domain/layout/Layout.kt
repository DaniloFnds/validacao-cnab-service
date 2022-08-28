package br.com.dhan.geraroperacao.domain.layout

data class Layout(
    val stream: String,
    val descricao: String,
    val codigoLayout: String
) fun Layout.layoutPorCodigo(): LayoutPorCodigoEnum = LayoutPorCodigoEnum.valueOf(this.codigoLayout)
