package br.com.dhan.geraroperacao.application.validacao.service.impl.coletor.model

import java.time.LocalDateTime

data class ConfiguracaoDto(
    val horarioInicialArquivoAquisicao: LocalDateTime,
    val horarioFinalArquivoAquisicao: LocalDateTime
)
