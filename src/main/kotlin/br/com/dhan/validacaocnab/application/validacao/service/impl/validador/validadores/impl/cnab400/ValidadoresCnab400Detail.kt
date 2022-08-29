package br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores.impl.cnab400

import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.model.RetornoValidacao
import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores.ValidacaoExecuter
import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores.Validador
import br.com.dhan.validacaocnab.domain.layout.LayoutPorCodigoEnum
import br.com.dhan.validacaocnab.domain.layout.LayoutPorCodigoEnum.LAYOUT_400
import br.com.dhan.validacaocnab.domain.registro.Header
import org.springframework.stereotype.Service
import kotlin.reflect.KClass

@Service
class ValidadoresCnab400Detail : Validador<Header> {
    private val listValidadores: List<ValidacaoExecuter<Header>> = listOf()

    override fun layout(): Set<LayoutPorCodigoEnum> {
        return setOf(LAYOUT_400)
    }

    override fun tipoRegistro(): KClass<Header> {
        return Header::class
    }

    override fun validar(registro: Header): Set<RetornoValidacao> {
        val setRetornoValidacao = mutableSetOf<RetornoValidacao>()
        listValidadores.forEach {
            it.validar(registro)?.run { setRetornoValidacao.add(this) }
        }
        return setRetornoValidacao
    }
}
