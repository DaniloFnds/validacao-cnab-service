package br.com.dhan.validacaocnab.application.registro.port

import br.com.dhan.validacaocnab.domain.registro.ArquivoCnab
import br.com.dhan.validacaocnab.domain.registro.RegistroCnab

interface RegistroCnabEventPort {

    fun create(registro: RegistroCnab): String

    fun createArquivo(arquivoCnab: ArquivoCnab)
}
