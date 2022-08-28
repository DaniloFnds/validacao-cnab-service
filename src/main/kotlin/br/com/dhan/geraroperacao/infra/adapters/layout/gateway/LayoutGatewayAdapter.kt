package br.com.dhan.geraroperacao.infra.adapters.layout.gateway

import br.com.dhan.geraroperacao.application.layout.port.LayoutPort
import br.com.dhan.geraroperacao.domain.layout.Layout
import org.springframework.stereotype.Service

@Service
class LayoutGatewayAdapter : LayoutPort {
    override fun retrieve(codigoLayout: String): Layout? {
        return Layout("cnab400", "Cnab 400", "20")
    }

}
