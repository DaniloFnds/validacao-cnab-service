package br.com.dhan.validacaocnab.infra.validacao.event.dto

data class ValidacaoEvent(
    val documentNumberFundo: String,
    val userNameRequested: String,
    val fileName: String,
    val filePath: String,
    val bucket: Boolean
)
