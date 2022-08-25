package br.com.dhan.geraroperacao.application

import org.springframework.stereotype.Service

@Service
class ChamadaRelatorioCarteira : ApiRelatorio<String, RetornoRelatorio> {

    override fun call(parametro: String): RetornoRelatorio {
        return RetornoRelatorio("parameetro: $parametro")
    }
}

fun String.toDto(): String {
    return this.substring(5, 10)
}
