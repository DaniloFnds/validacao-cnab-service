package br.com.dhan.validacaocnab.application.cnab.usecase

import br.com.dhan.validacaocnab.domain.cnab.Cnab
import java.io.InputStream

data class CnabCreateUseCase(
    val name: String,
    val binary: InputStream
)
