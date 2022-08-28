package br.com.dhan.geraroperacao.application.validacao.service.impl.coletor.model.cnab400

import br.com.dhan.geraroperacao.application.validacao.service.impl.coletor.model.ConfiguracaoDto
import br.com.dhan.geraroperacao.application.validacao.service.impl.coletor.model.SaidaColetor

data class SaidaCnab400Coletor(
    val configuracaoDto: ConfiguracaoDto
) : SaidaColetor
