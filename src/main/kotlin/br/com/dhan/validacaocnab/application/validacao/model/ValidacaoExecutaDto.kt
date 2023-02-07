package br.com.dhan.validacaocnab.application.validacao.model

import br.com.dhan.validacaocnab.domain.cnab.Cnab
import br.com.dhan.validacaocnab.domain.cnab.Layout

data class ValidacaoExecutaDto(
    val layout: Layout,
    val cnab: Cnab
)
