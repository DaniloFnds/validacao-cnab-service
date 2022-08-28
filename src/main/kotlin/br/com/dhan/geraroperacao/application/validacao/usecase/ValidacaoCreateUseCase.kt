package br.com.dhan.geraroperacao.application.validacao.usecase

data class ValidacaoCreateUseCase(
    val idArquivo: String,
    val idFundo: String,
    val nomeArquivo: String
)
