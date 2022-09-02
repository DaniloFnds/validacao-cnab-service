package br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores.impl.cnab400

import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.model.RetornoValidacao
import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores.ValidacaoExecuter
import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores.Validador
import br.com.dhan.validacaocnab.domain.layout.LayoutPorCodigoEnum
import br.com.dhan.validacaocnab.domain.layout.LayoutPorCodigoEnum.LAYOUT_400
import br.com.dhan.validacaocnab.domain.registro.Detail
import br.com.dhan.validacaocnab.domain.registro.Header
import org.springframework.stereotype.Service
import kotlin.reflect.KClass

@Service
class ValidadoresCnab400Detail : Validador<Detail> {
    private val listValidadores: List<ValidacaoExecuter<Detail>> = listOf()

    override fun layout(): Set<LayoutPorCodigoEnum> {
        return setOf(LAYOUT_400)
    }

    override fun tipoRegistro(): KClass<Detail> {
        return Detail::class
    }

    override fun validar(registro: Detail): Set<RetornoValidacao> {
        val setRetornoValidacao = mutableSetOf<RetornoValidacao>()
        listValidadores.forEach {
            it.validar(registro)?.run { setRetornoValidacao.add(this) }
        }
        return setRetornoValidacao
    }
}
