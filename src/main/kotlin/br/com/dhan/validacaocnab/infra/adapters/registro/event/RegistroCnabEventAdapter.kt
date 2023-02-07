/*
package br.com.dhan.validacaocnab.infra.adapters.registro.event

import br.com.dhan.proto.registrocnab.RegistroCnabMessageProto
import br.com.dhan.proto.registrocnab.RegistroCnabMessageProto.RegistroCnabDetailProto
import br.com.dhan.proto.registrocnab.RegistroCnabMessageProto.RegistroCnabProto
import br.com.dhan.schema.registro.RegistroCnabEvent
import br.com.dhan.schema.registro.RegistroCnabEventDetail
import br.com.dhan.schema.registro.RegistroCnabEventHeader
import br.com.dhan.schema.registro.RegistroCnabEventTrailer
import br.com.dhan.validacaocnab.application.registro.port.RegistroCnabPort
import br.com.dhan.validacaocnab.domain.registro.RegistroCnab
import br.com.dhan.validacaocnab.domain.registro.RegistroCnabDetail
import br.com.dhan.validacaocnab.domain.registro.RegistroCnabHeader
import br.com.dhan.validacaocnab.domain.registro.RegistroCnabTrailer
import br.com.dhan.validacaocnab.infra.adapters.registro.event.publishers.ArquivoCnabPublisher
import br.com.dhan.validacaocnab.infra.adapters.registro.event.publishers.RegistroCnabPublisher
import br.com.dhan.validacaocnab.infra.adapters.registro.jpa.entity.RegistroCnabDetailEntity
import br.com.dhan.validacaocnab.infra.adapters.registro.jpa.entity.RegistroCnabEntity
import com.google.protobuf.Timestamp
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service
import java.time.ZoneOffset

@Service
class RegistroCnabEventAdapter(
) : RegistroCnabPort {

    override fun create(registros: List<RegistroCnabEntity>): String {
        TODO("Not yet implemented")
    }

    private fun RegistroCnab.toEvent() =
    when (this) {
        is RegistroCnabDetail -> this.toEvent()
        is RegistroCnabHeader -> this.toEvent()
        is RegistroCnabTrailer -> this.toEvent()
        else -> throw IllegalArgumentException()
    }

private fun RegistroCnabDetail.toEvent(): RegistroCnabEvent {
    val thisRegistro = this
    return ModelMapper().map(this, RegistroCnabEventDetail::class.java).apply {
        id = thisRegistro.id
        dtype = "DETAIL"
        tipoRegistro = thisRegistro.tipoRegistro
        numeroSequencial = thisRegistro.numeroSequencial
        registro = thisRegistro.registro
    }
}

private fun RegistroCnabHeader.toEvent(): RegistroCnabEvent {
    val thisRegistro = this
    return ModelMapper().map(this, RegistroCnabEventHeader::class.java).apply {
        id = thisRegistro.id
        dtype = "HEADER"
        tipoRegistro = thisRegistro.tipoRegistro
        numeroSequencial = thisRegistro.numeroSequencial
        registro = thisRegistro.registro
    }
}

private fun RegistroCnabTrailer.toEvent(): RegistroCnabEvent {
    val thisRegistro = this
    return ModelMapper().map(this, RegistroCnabEventTrailer::class.java).apply {
        id = thisRegistro.id
        dtype = "TRAILER"
        tipoRegistro = thisRegistro.tipoRegistro
        numeroSequencial = thisRegistro.numeroSequencial
        registro = thisRegistro.registro
    }
}
*/
