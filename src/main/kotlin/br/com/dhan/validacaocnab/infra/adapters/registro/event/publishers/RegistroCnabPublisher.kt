package br.com.dhan.validacaocnab.infra.adapters.registro.event.publishers

import br.com.dhan.lib.commons.events.PublisherEvent
import br.com.dhan.schema.registro.RegistroCnabEvent
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.stereotype.Service

@Service
class RegistroCnabPublisher(
    @Value("\${spring.cloud.stream.bindings.registroCnabEventProducer-out-0.destination}")
    private val queueRegistroCreate: String,
    private val streamBridge: StreamBridge
) : PublisherEvent<RegistroCnabEvent> {

    override fun sendMessage(event: RegistroCnabEvent) {
        streamBridge.send(queueRegistroCreate, event)
    }
}
