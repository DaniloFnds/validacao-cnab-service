package br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores.impl

import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.model.RetornoValidacao
import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores.ValidadorDeLayout
import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores.ValidadorDeRegistro
import br.com.dhan.validacaocnab.domain.registro.Detail
import org.springframework.stereotype.Service
import kotlin.reflect.KClass

@Service
class ValidadorCnabDetail : ValidadorDeLayout<Detail> {

    override fun tipoRegistro(): KClass<Detail> = Detail::class

    override fun valida(registro: Detail, listValidadores: List<ValidadorDeRegistro<Detail>>): Set<RetornoValidacao> {
        val setRetornoValidacao = mutableSetOf<RetornoValidacao>()
        listValidadores.forEach {
            it.validar(registro)?.run { setRetornoValidacao.add(this) }
        }
        return setRetornoValidacao
    }
}
