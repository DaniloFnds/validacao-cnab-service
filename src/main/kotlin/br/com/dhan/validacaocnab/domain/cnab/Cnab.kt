package br.com.dhan.validacaocnab.domain.cnab

import java.io.InputStream

data class Cnab(
    val idArquivo: String,
    val idFundo: String,
    val nome: String,
    val inputFile: InputStream
)
