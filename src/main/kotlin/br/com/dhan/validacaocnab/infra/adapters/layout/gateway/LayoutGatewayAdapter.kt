package br.com.dhan.validacaocnab.infra.adapters.layout.gateway

import br.com.dhan.validacaocnab.application.layout.port.LayoutPort
import br.com.dhan.validacaocnab.domain.cnab.Layout
import br.com.dhan.validacaocnab.infra.adapters.layout.gateway.dto.FindLayoutRequest
import br.com.dhan.validacaocnab.infra.adapters.layout.gateway.dto.toLayout
import br.com.dhan.validacaocnab.infra.adapters.layout.gateway.feign.LayoutGateway
import org.springframework.stereotype.Service

@Service
class LayoutGatewayAdapter(
    private val layoutGateway: LayoutGateway
) : LayoutPort {

    // TODO colocar um retry
    override fun retrieve(documentNumberFundo: String, lines: List<String>): Layout? =
        layoutGateway.findLayout(FindLayoutRequest(documentNumberFundo, lines))
            .toLayout()
}
