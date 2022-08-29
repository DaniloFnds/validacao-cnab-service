package br.com.dhan.validacaocnab.application.validacao.service

import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.model.RetornoValidacao
import br.com.dhan.validacaocnab.domain.layout.Layout
import br.com.dhan.validacaocnab.domain.registro.TipoRegistro

interface ResolverValidadores {

    fun resolverAndExecute(layout: Layout, registro: TipoRegistro): Set<RetornoValidacao>
}
