package br.com.dhan.validacaocnab.application.registro.port

import br.com.dhan.validacaocnab.infra.adapters.registro.jpa.entity.RegistroCnabEntity

interface RegistroCnabPort {

    fun create(registros: List<RegistroCnabEntity>): String
}
