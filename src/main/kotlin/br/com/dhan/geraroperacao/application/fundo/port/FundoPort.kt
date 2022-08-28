package br.com.dhan.geraroperacao.application.fundo.port

import br.com.dhan.geraroperacao.domain.fundo.Fundo

interface FundoPort {

    fun retrieve(id: String): Fundo
}
