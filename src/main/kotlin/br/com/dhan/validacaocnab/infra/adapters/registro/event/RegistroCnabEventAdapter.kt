package br.com.dhan.validacaocnab.infra.adapters.registro.event

import br.com.dhan.lib.commons.events.BaseEvent
import br.com.dhan.schema.registro.ArquivoCnabEvent
import br.com.dhan.schema.registro.RegistroCnabEvent
import br.com.dhan.schema.registro.RegistroCnabEventDetail
import br.com.dhan.schema.registro.RegistroCnabEventHeader
import br.com.dhan.schema.registro.RegistroCnabEventTrailer
import br.com.dhan.validacaocnab.application.registro.port.RegistroCnabEventPort
import br.com.dhan.validacaocnab.domain.registro.ArquivoCnab
import br.com.dhan.validacaocnab.domain.registro.RegistroCnab
import br.com.dhan.validacaocnab.domain.registro.RegistroCnabDetail
import br.com.dhan.validacaocnab.domain.registro.RegistroCnabHeader
import br.com.dhan.validacaocnab.domain.registro.RegistroCnabTrailer
import br.com.dhan.validacaocnab.infra.adapters.registro.event.publishers.ArquivoCnabPublisher
import br.com.dhan.validacaocnab.infra.adapters.registro.event.publishers.RegistroCnabPublisher
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service

@Service
class RegistroCnabEventAdapter(
    private val registroCnabPublisher: RegistroCnabPublisher,
    private val arquivoCnabPublisher: ArquivoCnabPublisher
) : RegistroCnabEventPort {

    override fun create(registro: RegistroCnab): String {
        val event = registro.toEvent()
        registroCnabPublisher.sendMessage(event)
        return event.body.id
    }

    override fun createArquivo(arquivoCnab: ArquivoCnab) {
        arquivoCnabPublisher.sendMessage(arquivoCnab.toEvent())
    }
}

private fun ArquivoCnab.toEvent() = BaseEvent.create(
    ArquivoCnabEvent(
        id = this.idArquivo,
        idFundo = this.idFundo,
        nome = this.nome,
        totalRegistros = this.totalRegistros,
        totalValidos = this.totalValidos,
        totalInvalidos = this.totalInvalidos
    )
)

private fun RegistroCnab.toEvent() = BaseEvent.create(
    when (this) {
        is RegistroCnabDetail -> this.toEvent()
        is RegistroCnabHeader -> this.toEvent()
        is RegistroCnabTrailer -> this.toEvent()
        else -> throw IllegalArgumentException()
    }
)

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
