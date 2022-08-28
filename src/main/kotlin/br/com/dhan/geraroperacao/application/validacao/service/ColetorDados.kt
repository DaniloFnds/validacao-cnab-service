package br.com.dhan.geraroperacao.application.validacao.service

import br.com.dhan.geraroperacao.application.validacao.service.impl.coletor.model.EntradaColetor
import br.com.dhan.geraroperacao.application.validacao.service.impl.coletor.model.SaidaColetor
import br.com.dhan.geraroperacao.domain.layout.LayoutPorCodigoEnum

interface ColetorDados<out S : SaidaColetor, in E : EntradaColetor> {

    fun layout(): Set<LayoutPorCodigoEnum>

    fun coletar(entrada: E): S
}
