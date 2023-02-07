package br.com.dhan.validacaocnab.application.validacao.service

import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores.ValidadorDeLayout
import br.com.dhan.validacaocnab.application.validacao.service.impl.validador.validadores.ValidadorDeRegistro
import br.com.dhan.validacaocnab.domain.cnab.Layout
import br.com.dhan.validacaocnab.domain.registro.Detail
import br.com.dhan.validacaocnab.domain.registro.Registro

interface ResolverValidadores {

    // TODO refazer esse metodo nos testes
    fun resolveValidadorDeLayout(registro: Registro): ValidadorDeLayout<Registro>
    fun resolveValidacoesDoRegistro(layout: Layout): List<ValidadorDeRegistro<Registro>>
}
