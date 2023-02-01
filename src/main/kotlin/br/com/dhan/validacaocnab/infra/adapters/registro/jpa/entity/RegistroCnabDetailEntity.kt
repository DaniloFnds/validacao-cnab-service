package br.com.dhan.validacaocnab.infra.adapters.registro.jpa.entity
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("DETAIL")
class RegistroCnabDetailEntity : RegistroCnabEntity() {
    var cpfCnpjCedente: String? = null
    var nomeCedente: String? = null
    var codigoCedente: Int? = null
    var dataNascimentoSacado: LocalDate? = null
    var seuNumero: String? = null
    var numeroParcela: Int? = null
    var nossoNumero: String? = null
    var taxaJuros: BigDecimal? = null
    var codigoOcorrencia: String? = null
    var numeroContrato: String? = null
    var dataVencimento: LocalDate? = null
    var valorTitulo: BigDecimal? = null
    var valorPago: BigDecimal? = null
    var codigoBanco: String? = null
    var anoVeiculo: String? = null
    var codigoEspecie: String? = null
    var dataEmissao: LocalDate? = null
    var cpfCnpjSacado: String? = null
    var nomeSacado: String? = null
    var logradouroSacado: String? = null
    var bairroSacado: String? = null
    var cepSacado: String? = null
    var cidadeSacado: String? = null
    var estadoSacado: String? = null
    var codigoMotivoOcorrencia01: Int? = null
    var codigoMotivoOcorrencia02: Int? = null
    var tipoPessoa: String? = null
    var valorVeiculo: BigDecimal? = null
    var codigoMotivoOcorrencia03: Int? = null
    var codigoMotivoOcorrencia04: Int? = null
    var valorPresenteParcela: BigDecimal? = null
    var valorAbatimento: BigDecimal? = null
    var numeroCobranca: String? = null
    var numeroLogradouroSacado: String? = null
    var complementoEnderecoSacado: String? = null
    var telefoneSacado: String? = null
    var faxSacado: String? = null
    var numeroInscricao: Int? = null
    var codigoEmpresa: Int? = null
    var dacNossoNumero: Int? = null
    var valorBaixa: BigDecimal? = null
    var bancoCobranca: Int? = null
    var agenciaCobranca: Int? = null
    var dacAgenciaCobranca: Int? = null
    var valorDesconto: BigDecimal? = null
    var valorJuros: BigDecimal? = null
    var dataLiquidacao: LocalDate? = null
    var termoCessao: String? = null
    var numeroNotaFiscal: String? = null
    var coobrigacao: Int? = null
    var chaveNfe: String? = null
    var tpContrato: String? = null
    var valorContrato: BigDecimal? = null
    var chassi: String? = null
    var cnpjEnteConsignante: String? = null
    var cnpjOriginador: String? = null
    var numeroContratoC3: String? = null
    var modalidade: Int? = null
    var numeroParcelaC3: String? = null
    var codBancoCobranca: String? = null
    var natureza: Int? = null
    var classificacaoRiscoCedente: String? = null
    var qtdParcelas: Int? = null
    var dataEntrada: LocalDate? = null
    var codigoLoja: Int? = null
    var codigoProduto: Int? = null
    var identificacao: String? = null
    var indice: Int? = null
    var valorJurosDiaAtraso: BigDecimal? = null
    var multa: BigDecimal? = null
    var dataPrevistoPagamento: LocalDate? = null
    var numeroNsu: String? = null
    var valorMdrNsu: BigDecimal? = null
    var parcelaNsu: Int? = null
    var bandeiraNsu: String? = null
    var adquirenciaNsu: String? = null
    var codigoEstabelecimento: String? = null
}
