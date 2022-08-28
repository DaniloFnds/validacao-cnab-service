package br.com.dhan.geraroperacao.application.importacao.usecase

import br.com.dhan.geraroperacao.application.importacao.model.StatusImportacaoEnum

data class CreateNotifyImportacao(
    val id: String,
    val statusImportacao: StatusImportacaoEnum
)
