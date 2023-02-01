package br.com.dhan.validacaocnab.application.cnab.usecase

data class ArquivoCreate(
    val id: String,
    val idFundo: String,
    val nome: String,
    val totalInvalidos: Int = 0,
    val totalValidos: Int = 0,
    val totalRegistros: Int = 0
)
