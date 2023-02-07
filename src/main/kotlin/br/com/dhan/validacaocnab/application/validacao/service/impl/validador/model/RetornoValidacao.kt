package br.com.dhan.validacaocnab.application.validacao.service.impl.validador.model

import br.com.dhan.validacaocnab.domain.registro.Registro

data class RetornoValidacao(
    val registro: Registro,
    val campo: String,
    val mensagem: String
)

