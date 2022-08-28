package br.com.dhan.geraroperacao.application.layout.port

import br.com.dhan.geraroperacao.domain.layout.Layout

interface LayoutPort {
    fun retrieve(codigoLayout: String): Layout?
}
