package br.com.dhan.validacaocnab.infra.adapters.layout.gateway.dto

data class LayoutResponse(
    val streamName: String,
    val layoutCode: String,
    val description: String
)
