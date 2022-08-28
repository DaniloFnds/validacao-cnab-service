package br.com.dhan.geraroperacao.application.cnab.usecase

import java.io.InputStream

data class DownloadCnabUseCase(
    val idArquivo: String,
    val nome: String,
    val idFundo: String
)
