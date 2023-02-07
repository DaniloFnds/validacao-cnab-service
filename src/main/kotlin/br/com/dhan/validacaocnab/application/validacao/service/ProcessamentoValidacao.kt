package br.com.dhan.validacaocnab.application.validacao.service

import br.com.dhan.validacaocnab.domain.cnab.Cnab

interface ProcessamentoValidacao {

    fun processar(cnab: Cnab): Cnab?
}
