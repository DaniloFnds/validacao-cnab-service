package br.com.dhan.validacaocnab.application.validacao.service

import br.com.dhan.validacaocnab.domain.cnab.Cnab
import br.com.dhan.validacaocnab.domain.layout.Layout
import br.com.dhan.validacaocnab.domain.registro.ArquivoCnab

interface ProcessamentoValidacao {

    suspend fun processar(layout: Layout, cnab: Cnab): ArquivoCnab
}
