package br.com.dhan.geraroperacao.application

interface ApiRelatorio<in PARAMETRO, out RETORNO> {
    fun call(parametro: PARAMETRO): RETORNO
}
