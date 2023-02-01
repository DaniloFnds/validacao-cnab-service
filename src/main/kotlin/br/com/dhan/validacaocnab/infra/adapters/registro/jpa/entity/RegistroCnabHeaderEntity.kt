package br.com.dhan.validacaocnab.infra.adapters.registro.jpa.entity

import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("HEADER")
class RegistroCnabHeaderEntity : RegistroCnabEntity() {
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
}
