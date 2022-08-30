package br.com.dhan.validacaocnab.application.validacao.model

data class ArquivoProcessado(
    val idArquivo: String,
    val idFundo: String,
    val nome: String,
    val totalInvalidos: Int = 0,
    val totalValidos: Int = 0,
    val totalRegistros: Int = 0
    // OUTRRAS INFOS DO ARQUIVO TODO
)
