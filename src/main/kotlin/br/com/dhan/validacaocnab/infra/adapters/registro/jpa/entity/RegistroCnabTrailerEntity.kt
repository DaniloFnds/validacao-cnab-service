package br.com.dhan.validacaocnab.infra.adapters.registro.jpa.entity

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("TRAILLER")
class RegistroCnabTrailerEntity : RegistroCnabEntity() {
    var identificacaoArquivoRemessa: String? = null
}
