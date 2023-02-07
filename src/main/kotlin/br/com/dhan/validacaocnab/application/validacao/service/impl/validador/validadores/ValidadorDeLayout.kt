package br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores

import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.model.RetornoValidacao
import br.com.dhan.validacaocnab.domain.layout.LayoutPorCodigoEnum
import br.com.dhan.validacaocnab.domain.registro.Registro
import kotlin.reflect.KClass

interface ValidadorDeLayout<out T : Registro> {
    fun tipoRegistro(): KClass<@UnsafeVariance T>
    fun valida(registro: @UnsafeVariance T, listValidadores: List<ValidadorDeRegistro<@UnsafeVariance T>>): Set<RetornoValidacao>
}
