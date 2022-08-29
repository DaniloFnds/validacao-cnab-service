package br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores

import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.model.RetornoValidacao
import br.com.dhan.validacaocnab.domain.layout.LayoutPorCodigoEnum
import br.com.dhan.validacaocnab.domain.registro.TipoRegistro
import kotlin.reflect.KClass

interface Validador<T : TipoRegistro> {
    fun layout(): Set<LayoutPorCodigoEnum>
    fun tipoRegistro(): KClass<T>
    fun validar(registro: T): Set<RetornoValidacao>
}
