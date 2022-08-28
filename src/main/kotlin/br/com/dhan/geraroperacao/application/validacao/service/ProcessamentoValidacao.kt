package br.com.dhan.geraroperacao.application.validacao.service

import br.com.dhan.geraroperacao.domain.cnab.Cnab
import br.com.dhan.geraroperacao.domain.layout.Layout

interface ProcessamentoValidacao {

    fun processar(layout: Layout, cnab: Cnab)
}
