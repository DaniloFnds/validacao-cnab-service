package br.com.dhan.validacaocnab.application.layout.port

import br.com.dhan.validacaocnab.domain.layout.Layout

interface LayoutPort {
    fun retrieve(codigoLayout: String): Layout?
}
