package br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores

import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.model.RetornoValidacao
import br.com.dhan.validacaocnab.domain.layout.LayoutPorCodigoEnum
import br.com.dhan.validacaocnab.domain.registro.Registro
import kotlin.reflect.KClass

abstract class ValidadorDeRegistro<T : Registro> {

    fun validar(registro: T): RetornoValidacao? {
        if (condicaoInvalido(registro)) {
            return RetornoValidacao(
                registro = registro,
                campo = campo(registro),
                mensagem = mensagemInvalido(registro)
            )
        }
        return null
    }

    abstract fun condicaoInvalido(registro: T): Boolean

    abstract fun mensagemInvalido(registro: T): String

    abstract fun campo(registro: T): String

    abstract fun layouts(): Set<LayoutPorCodigoEnum>

    abstract fun registro(): KClass<T>
}
