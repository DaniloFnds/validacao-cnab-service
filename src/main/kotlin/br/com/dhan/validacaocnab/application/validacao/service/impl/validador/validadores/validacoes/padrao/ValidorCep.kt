package br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores.validacoes.padrao

import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores.ReferenciaLayouts
import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores.ValidadorDeRegistro
import br.com.dhan.validacaocnab.domain.layout.LayoutPorCodigoEnum
import br.com.dhan.validacaocnab.domain.registro.Detail
import br.com.dhan.validacaocnab.domain.registro.RegistroCnabDetail
import org.springframework.stereotype.Service
import kotlin.reflect.KClass

@Service
class ValidorCep : ValidadorDeRegistro<Detail>() {

    override fun condicaoInvalido(registro: Detail): Boolean =
        (registro as RegistroCnabDetail).cepSacado.isNullOrEmpty()

    override fun mensagemInvalido(registro: Detail): String = "Cep Sacado Invalido"

    override fun campo(registro: Detail): String = "cepSacado"

    override fun layouts(): Set<LayoutPorCodigoEnum> =
        setOf(*ReferenciaLayouts.LAYOUTS_TAMANHO_400, *ReferenciaLayouts.LAYOUTS_TAMANHO_444)

    override fun registro(): KClass<Detail> = Detail::class
}
