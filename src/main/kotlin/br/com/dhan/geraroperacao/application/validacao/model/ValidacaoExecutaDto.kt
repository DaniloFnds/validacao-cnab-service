package br.com.dhan.geraroperacao.application.validacao.model

import br.com.dhan.geraroperacao.domain.cnab.Cnab
import br.com.dhan.geraroperacao.domain.layout.Layout

data class ValidacaoExecutaDto(
    val layout: Layout,
    val cnab: Cnab
)
