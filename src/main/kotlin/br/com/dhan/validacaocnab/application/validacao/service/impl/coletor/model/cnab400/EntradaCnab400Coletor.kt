package br.com.dhan.validacaocnab.application.validacao.service.impl.coletor.model.cnab400

import br.com.dhan.validacaocnab.application.validacao.service.impl.coletor.model.EntradaColetor

data class EntradaCnab400Coletor(
    val idArquivo: String,
    val idFundo: String
) : EntradaColetor
