package br.com.dhan.validacaocnab.application.validacao.service

import br.com.dhan.schema.remessa.v1.RemessaEvent
import br.com.dhan.validacaocnab.domain.layout.LayoutPorCodigoEnum

interface ExecuteValidacaoPorLayout {

    fun layouts(): Set<LayoutPorCodigoEnum>
    fun valida(remessaEvent: RemessaEvent)
}
