package br.com.dhan.validacaocnab.application.layout.port

import br.com.dhan.validacaocnab.domain.cnab.Layout

interface LayoutPort {
    fun retrieve(documentNumberFundo: String, lines: List<String>): Layout?
}
