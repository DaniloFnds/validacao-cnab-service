package br.com.dhan.validacaocnab.application.cnab.usecase

data class DownloadCnabUseCase(
    val bucket: Boolean,
    val path: String
)
