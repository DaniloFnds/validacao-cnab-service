package br.com.dhan.geraroperacao.infra.adapters.fundo.gateway

import br.com.dhan.geraroperacao.application.fundo.port.FundoPort
import br.com.dhan.geraroperacao.domain.fundo.Fundo
import org.springframework.stereotype.Service

@Service
class FundoGatewayAdapter : FundoPort {

    override fun retrieve(id: String): Fundo {
        // TODO fazer o client do feign
        return Fundo(id = "138140d11dd211b29d504404aeca8391", nome = "whiten", documento = "Je4SeR9", codigoLayout = "20")
    }
}
