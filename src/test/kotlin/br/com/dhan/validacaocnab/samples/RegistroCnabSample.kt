package br.com.dhan.validacaocnab.samples

import br.com.dhan.validacaocnab.domain.registro.RegistroCnabDetail
import br.com.dhan.validacaocnab.domain.registro.RegistroCnabHeader

object RegistroCnabSample {

    fun createDetail(): RegistroCnabDetail = RegistroCnabDetail().apply {
        cpfCnpjCedente = "90020787065"
        nomeCedente = "destroy"
    }


    fun createHeader(): RegistroCnabHeader = RegistroCnabHeader().apply {
        identificacaoArquivoRemessa = "12asda"
    }
}
