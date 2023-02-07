package br.com.dhan.validacaocnab.application.validacao.usecase

data class ValidationCreateUseCase(
    val documentNumberFundo: String,
    val bucket: Boolean,
    val fileName: String,
    val filePath: String,
    val userNameRequested: String
)
