package br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores

import br.com.dhan.validacaocnab.application.validacao.service.ResolverValidadores
import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.model.RetornoValidacao
import br.com.dhan.validacaocnab.commons.exceptions.LayoutNotFoundException
import br.com.dhan.validacaocnab.domain.layout.Layout
import br.com.dhan.validacaocnab.domain.layout.layoutPorCodigo
import br.com.dhan.validacaocnab.domain.registro.TipoRegistro
import org.springframework.stereotype.Service

@Service
class ResolverValidadoresImpl(
    private val listValidadores: List<Validador<TipoRegistro>>
) : ResolverValidadores {

    override fun resolverAndExecute(layout: Layout, registro: TipoRegistro): Set<RetornoValidacao> {
        return listValidadores.find {
            it.layout().contains(layout.layoutPorCodigo()) && it.tipoRegistro().isInstance(registro)
        }?.run {
            validar(registro)
        } ?: throw LayoutNotFoundException("Validadores nao encontrado.: layout: $layout tipoRegistro: $registro")
    }
}
