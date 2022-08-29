package br.com.dhan.validacaocnab.application.layout

import br.com.dhan.validacaocnab.application.layout.port.LayoutPort
import br.com.dhan.validacaocnab.application.layout.usecase.LayoutRetrieveUseCase
import br.com.dhan.validacaocnab.commons.exceptions.LayoutNotFoundException
import br.com.dhan.validacaocnab.domain.layout.Layout
import org.springframework.stereotype.Service

@Service
class LayoutDiscoverHandler(
    private val layoutPort: LayoutPort
) {

    fun handler(layoutRetrieveUseCase: LayoutRetrieveUseCase): Layout {
        return layoutPort.retrieve(layoutRetrieveUseCase.codigoLayout) ?: throw LayoutNotFoundException()
    }
}
