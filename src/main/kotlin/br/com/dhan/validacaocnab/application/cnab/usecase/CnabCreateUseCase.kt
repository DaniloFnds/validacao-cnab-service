package br.com.dhan.validacaocnab.application.cnab.usecase

import br.com.dhan.validacaocnab.domain.cnab.Cnab
import java.io.InputStream

data class CnabCreateUseCase(
    val idArquivo: String,
    val idFundo: String,
    val nome: String,
    val inputFile: InputStream
)

fun CnabCreateUseCase.toDomain() = Cnab(
    this.idArquivo, this.idFundo, this.nome, this.inputFile
)
