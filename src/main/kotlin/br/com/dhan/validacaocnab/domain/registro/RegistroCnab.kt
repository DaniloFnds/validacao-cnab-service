package br.com.dhan.validacaocnab.domain.registro

import br.com.dhan.lib.commons.extensions.GenUUID
import br.com.dhan.validacaocnab.application.validacao.service.impl.coletor.model.SaidaColetor

sealed class RegistroCnab : TipoRegistro {
    var id: String = GenUUID.get()
    var idArquivo: String = ""
    var tipoRegistro: Int? = null
    var numeroSequencial: Int? = null
    var registro: String? = null
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
