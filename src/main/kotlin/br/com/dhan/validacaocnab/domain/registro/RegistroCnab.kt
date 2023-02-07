package br.com.dhan.validacaocnab.domain.registro

import br.com.dhan.lib.commons.extensions.GenUUID

sealed class RegistroCnab : Registro {
    val id: String = GenUUID.get()
    var idCnab: String? = null
    var tipoRegistro: Int? = null
    var numeroSequencial: Int? = null
    var registro: String? = null
}

sealed interface Validation

sealed class Invalido() : Validation
sealed class Valido() : Validation

class RegistroInvalido(
    val registroCnab: RegistroCnab
) : Invalido()

class RegistroValido(
    val registroCnab: RegistroCnab
) : Valido()
