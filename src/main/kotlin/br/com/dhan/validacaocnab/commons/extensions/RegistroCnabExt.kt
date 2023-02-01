package br.com.dhan.validacaocnab.commons.extensions

import br.com.dhan.validacaocnab.commons.mappers.MapperObject
import br.com.dhan.validacaocnab.domain.registro.RegistroCnab
import br.com.dhan.validacaocnab.domain.registro.RegistroCnabDetail
import br.com.dhan.validacaocnab.domain.registro.RegistroCnabHeader
import br.com.dhan.validacaocnab.domain.registro.RegistroCnabTrailer
import br.com.dhan.validacaocnab.infra.adapters.registro.jpa.entity.RegistroCnabDetailEntity
import br.com.dhan.validacaocnab.infra.adapters.registro.jpa.entity.RegistroCnabEntity
import br.com.dhan.validacaocnab.infra.adapters.registro.jpa.entity.RegistroCnabHeaderEntity
import br.com.dhan.validacaocnab.infra.adapters.registro.jpa.entity.RegistroCnabTrailerEntity

fun RegistroCnab.toEntity(): RegistroCnabEntity =
    when (this) {
        is RegistroCnabDetail -> this.toEntity()
        is RegistroCnabHeader -> this.toEntity()
        is RegistroCnabTrailer -> this.toEntity()
    }

fun RegistroCnabDetail.toEntity(): RegistroCnabDetailEntity {
    return RegistroCnabDetailEntity().also {
        MapperObject.modelMapper.map(this, it)
    }
}

fun RegistroCnabHeader.toEntity(): RegistroCnabHeaderEntity {
    return RegistroCnabHeaderEntity().also {
        MapperObject.modelMapper.map(this, it)
    }
}

fun RegistroCnabTrailer.toEntity(): RegistroCnabTrailerEntity {
    return RegistroCnabTrailerEntity().also {
        MapperObject.modelMapper.map(this, it)
    }
}
