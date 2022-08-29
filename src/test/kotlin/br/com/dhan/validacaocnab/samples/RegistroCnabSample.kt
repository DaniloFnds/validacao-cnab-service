package br.com.dhan.validacaocnab.samples

import br.com.dhan.validacaocnab.domain.registro.RegistroCnab
import br.com.dhan.validacaocnab.domain.registro.RegistroCnabDetail

object RegistroCnabSample {

    fun create(): RegistroCnab = RegistroCnabDetail().apply {
        cpfCnpjCedente = "90020787065"
        nomeCedente = "destroy"
    }
}
