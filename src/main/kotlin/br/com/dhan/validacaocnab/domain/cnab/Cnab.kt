package br.com.dhan.validacaocnab.domain.cnab

import br.com.dhan.validacaocnab.commons.enums.StatusValidations
import de.huxhorn.sulky.ulid.ULID
import java.io.Reader

data class Cnab(
    val id: String = ULID().nextULID(),
    val documentNumberFundo: String,
    val name: String,
    val status: StatusValidations = StatusValidations.WAITING,
    val file: Reader
)
