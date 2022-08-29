package br.com.dhan.validacaocnab.application.importacao.usecase

import br.com.dhan.validacaocnab.application.importacao.model.StatusImportacaoEnum

data class CreateNotifyImportacao(
    val id: String,
    val statusImportacao: StatusImportacaoEnum
)
