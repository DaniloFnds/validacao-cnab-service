package br.com.dhan.validacaocnab.infra.adapters.registro.event.publishers

import br.com.dhan.lib.commons.events.BaseEvent
import br.com.dhan.lib.commons.events.Publisher
import br.com.dhan.schema.registro.ArquivoCnabEvent
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.stereotype.Service

@Service
class ArquivoCnabPublisher(
    @Value("\${spring.cloud.stream.bindings.arquivoCnabEventProducer-out-0.destination}")
    private val queueRegistroCreate: String,
    private val streamBridge: StreamBridge
) : Publisher<ArquivoCnabEvent> {
    override fun sendMessage(event: BaseEvent<ArquivoCnabEvent>) {
        streamBridge.send(queueRegistroCreate, event)
    }
}
