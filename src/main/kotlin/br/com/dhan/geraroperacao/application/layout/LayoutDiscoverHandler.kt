package br.com.dhan.geraroperacao.application.layout

import br.com.dhan.geraroperacao.application.cnab.usecase.CnabCreateUseCase
import br.com.dhan.geraroperacao.application.layout.port.LayoutPort
import br.com.dhan.geraroperacao.application.layout.usecase.LayoutRetrieveUseCase
import br.com.dhan.geraroperacao.commons.exceptions.LayoutNotFoundException
import br.com.dhan.geraroperacao.domain.layout.Layout
import org.springframework.stereotype.Service

@Service
class LayoutDiscoverHandler(
    private val layoutPort: LayoutPort
) {

    fun handler(layoutRetrieveUseCase: LayoutRetrieveUseCase): Layout {
        return layoutPort.retrieve(layoutRetrieveUseCase.codigoLayout) ?: throw LayoutNotFoundException()
    }
}
