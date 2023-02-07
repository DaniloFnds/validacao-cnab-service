package br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores.impl

import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.model.RetornoValidacao
import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores.ValidadorDeLayout
import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores.ValidadorDeRegistro
import br.com.dhan.validacaocnab.domain.registro.Header
import org.springframework.stereotype.Service
import kotlin.reflect.KClass

@Service
class ValidadorCnabHeader : ValidadorDeLayout<Header> {

    override fun tipoRegistro(): KClass<Header> {
        return Header::class
    }

    override fun valida(registro: Header, listValidadores: List<ValidadorDeRegistro<Header>>): Set<RetornoValidacao> {
        val setRetornoValidacao = mutableSetOf<RetornoValidacao>()
        listValidadores.forEach {
            it.validar(registro)?.run { setRetornoValidacao.add(this) }
        }
        return setRetornoValidacao
    }
}
