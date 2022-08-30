package br.com.dhan.validacaocnab.domain.registro

import br.com.dhan.lib.commons.extensions.GenUUID
import br.com.dhan.validacaocnab.application.validacao.service.impl.coletor.model.SaidaColetor

sealed class RegistroCnab : TipoRegistro {
    private val id: String = GenUUID.get()
    var idArquivo: String = ""
    private val tipoRegistro: Int? = null
    private val numeroSequencial: Int? = null
    private val registro: String? = null
    var coletorDados: SaidaColetor? = null
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
