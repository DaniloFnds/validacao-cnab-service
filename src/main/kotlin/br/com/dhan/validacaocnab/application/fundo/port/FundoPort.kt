package br.com.dhan.validacaocnab.application.fundo.port

import br.com.dhan.validacaocnab.domain.fundo.Fundo

interface FundoPort {

    fun retrieve(id: String): Fundo
}
