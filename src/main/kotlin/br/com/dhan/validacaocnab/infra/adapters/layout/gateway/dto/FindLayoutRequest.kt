package br.com.dhan.validacaocnab.infra.adapters.layout.gateway.dto

import br.com.dhan.validacaocnab.domain.cnab.Layout

data class FindLayoutRequest(
    val documentNumberFundo: String,
    val lines: List<String>
)

fun LayoutResponse.toLayout() = Layout(
    this.streamName,
    this.description,
    this.layoutCode
)
