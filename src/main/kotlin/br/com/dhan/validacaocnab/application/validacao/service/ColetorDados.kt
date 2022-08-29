package br.com.dhan.validacaocnab.application.validacao.service

import br.com.dhan.validacaocnab.application.validacao.service.impl.coletor.model.SaidaColetor
import br.com.dhan.validacaocnab.domain.layout.LayoutPorCodigoEnum

interface ColetorDados<out S : SaidaColetor> {

    fun layout(): Set<LayoutPorCodigoEnum>

    fun coletar(): S
}
