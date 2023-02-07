package br.com.dhan.validacaocnab.domain.registro

import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.Column

class RegistroCnabHeader : RegistroCnab(), Header {
    var identificacaoArquivoRemessa: String? = null

    var codigoConsultoria: String? = null

    var nomeConsultoria: String? = null

    var codigoBanco: Int? = null

    var nomeBanco: String? = null

    var dataGravacao: LocalDate? = null

    var codigoFundo: String? = null

    var cnpjOriginador: String? = null

    var nuReserva: String? = null

    var identificadorCoobrigacao: Int? = null

    var tpPartRespTarifacao: Int? = null

    var percTarifacao: BigDecimal? = null

    var dataMovimento: LocalDate? = null

    var naturezaOperacao: String? = null

    var segmento: Int? = null

    var taxaCessaoAnual: BigDecimal? = null

    var taxaCessao: BigDecimal? = null

    var instituicaoPagadora: Int? = null

    var cpfCnpjCedente: String? = null

    var agenciaDeposito: Int? = null

    var contaDeposito: Int? = null

    var codigoBancoDeposito: Int? = null

    var valorRetencao: BigDecimal? = null

    var coobrigacaoHeader: String? = null
    var bancoCedente: String? = null

    var agenciaCedente: String? = null

    var digitoAgenciaCedente: String? = null

    var contaCedente: String? = null

    var digitoContaCedente: String? = null

    var tipoPagamento: String? = null
}
