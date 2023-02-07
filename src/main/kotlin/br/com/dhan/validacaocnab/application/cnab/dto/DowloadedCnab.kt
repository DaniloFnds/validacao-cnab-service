package br.com.dhan.validacaocnab.application.cnab.dto

import java.io.InputStream

data class DowloadedCnab(
    val binary: InputStream
)
