package br.com.dhan.validacaocnab.application.validacao.service.impl.processamento

import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.model.RetornoValidacao
import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores.ValidadorDeLayout
import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores.ValidadorDeRegistro
import br.com.dhan.validacaocnab.domain.registro.Registro

class ValidatorExecuter(
    private val validadorDeLayout: ValidadorDeLayout<Registro>,
    private val listValidadoresDeRegistro: List<ValidadorDeRegistro<Registro>>
) {

    fun executa(registro: Registro): Set<RetornoValidacao> =
        validadorDeLayout.valida(registro, listValidadoresDeRegistro)
}
