package br.com.dhan.validacaocnab.infra.adapters.registro.event

import br.com.dhan.lib.commons.events.BaseEvent
import br.com.dhan.schema.registro.RegistroCnabEvent
import br.com.dhan.schema.registro.RegistroCnabEventDetail
import br.com.dhan.schema.registro.RegistroCnabEventHeader
import br.com.dhan.schema.registro.RegistroCnabEventTrailer
import br.com.dhan.validacaocnab.application.registro.port.RegistroCnabEventPort
import br.com.dhan.validacaocnab.domain.registro.RegistroCnab
import br.com.dhan.validacaocnab.domain.registro.RegistroCnabDetail
import br.com.dhan.validacaocnab.domain.registro.RegistroCnabHeader
import br.com.dhan.validacaocnab.domain.registro.RegistroCnabTrailer
import org.springframework.stereotype.Service

@Service
class RegistroCnabEventAdapter(
    private val registroCnabPublisher: RegistroCnabPublisher
) : RegistroCnabEventPort {

    override fun create(registro: RegistroCnab): String {
        val event = registro.toEvent()
        registroCnabPublisher.sendMessage(event)
        return event.body.id
    }
}

private fun RegistroCnab.toEvent(): BaseEvent<RegistroCnabEvent> {
    return BaseEvent.create(
        when (this) {
            is RegistroCnabDetail -> this.toEvent()
            is RegistroCnabHeader -> this.toEvent()
            is RegistroCnabTrailer -> this.toEvent()
        }
    )
}

private fun RegistroCnabDetail.toEvent(): RegistroCnabEventDetail {
    val registroCnabDetail = this
    return RegistroCnabEventDetail().apply {
        cepSacado = registroCnabDetail.cepSacado
    }
}

private fun RegistroCnabHeader.toEvent(): RegistroCnabEventHeader {
    val registroCnabHeader = this
    return RegistroCnabEventHeader().apply {
        identificacaoArquivoRemessa = registroCnabHeader.identificacaoArquivoRemessa
    }
}

private fun RegistroCnabTrailer.toEvent(): RegistroCnabEventTrailer {
    val registroCnabTrailer = this
    return RegistroCnabEventTrailer().apply {
        identificacaoArquivoRemessa = registroCnabTrailer.identificacaoArquivoRemessa
    }
}
