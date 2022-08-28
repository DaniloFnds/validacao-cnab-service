package br.com.dhan.geraroperacao.application.validacao.service

import br.com.dhan.schema.remessa.v1.RemessaEvent

interface ExecuteValidacaoPorLayout {

    fun valida(remessaEvent: RemessaEvent)
}
