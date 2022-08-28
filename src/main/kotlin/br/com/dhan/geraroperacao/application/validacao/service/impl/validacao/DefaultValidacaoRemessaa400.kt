package br.com.dhan.geraroperacao.application.validacao.service.impl.validacao

import br.com.dhan.geraroperacao.application.validacao.model.ValidacaoExecutaDto
import br.com.dhan.geraroperacao.application.validacao.service.BeanReaderDiscover
import br.com.dhan.geraroperacao.application.validacao.service.ExecuteValidacaoPorLayout
import br.com.dhan.schema.remessa.v1.RemessaEvent
import org.springframework.stereotype.Service

@Service
class DefaultValidacaoRemessaa400(
) : ExecuteValidacaoPorLayout {
    override fun valida(remessaEvent: RemessaEvent) {

        /*
            aqui sera a parte q vai aplicar por record
            
         */

    }
}
