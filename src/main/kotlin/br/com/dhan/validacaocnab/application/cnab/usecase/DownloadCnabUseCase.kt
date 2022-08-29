package br.com.dhan.validacaocnab.application.cnab.usecase

data class DownloadCnabUseCase(
    val idArquivo: String,
    val nome: String,
    val idFundo: String
)
