package br.com.dhan.validacaocnab.application.layout

import br.com.dhan.validacaocnab.application.layout.port.LayoutPort
import br.com.dhan.validacaocnab.application.layout.usecase.LayoutRetrieveUseCase
import br.com.dhan.validacaocnab.commons.exceptions.LayoutNotFoundException
import br.com.dhan.validacaocnab.commons.extensions.getLines
import br.com.dhan.validacaocnab.domain.cnab.Layout
import org.springframework.stereotype.Service

@Service
class LayoutDiscoverHandler(
    private val layoutPort: LayoutPort
) {

    fun handler(layoutRetrieveUseCase: LayoutRetrieveUseCase): Layout {
        val lines = layoutRetrieveUseCase.cnab.file.buffered().getLines(3)
        return layoutPort.retrieve(layoutRetrieveUseCase.cnab.documentNumberFundo, lines)
            ?: throw LayoutNotFoundException("layout not found")
    }
}
