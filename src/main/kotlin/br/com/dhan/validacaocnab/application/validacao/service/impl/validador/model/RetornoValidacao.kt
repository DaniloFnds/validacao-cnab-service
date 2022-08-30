package br.com.dhan.validacaocnab.application.validacao.service.impl.validador.model

import br.com.dhan.validacaocnab.domain.registro.TipoRegistro

data class RetornoValidacao(
    val registro: TipoRegistro,
    val campo: String,
    val mensagem: String
)

