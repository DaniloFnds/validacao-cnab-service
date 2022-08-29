package br.com.dhan.validacaocnab.application.validacao.service

import br.com.dhan.validacaocnab.domain.cnab.Cnab
import br.com.dhan.validacaocnab.domain.layout.Layout

interface ProcessamentoValidacao {

    fun processar(layout: Layout, cnab: Cnab)
}
