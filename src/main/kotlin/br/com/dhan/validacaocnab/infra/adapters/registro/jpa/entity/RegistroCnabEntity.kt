package br.com.dhan.validacaocnab.infra.adapters.registro.jpa.entity

import br.com.dhan.lib.commons.entities.AbstractEntity
import javax.persistence.Column
import javax.persistence.DiscriminatorColumn
import javax.persistence.Entity
import javax.persistence.Inheritance
import javax.persistence.Table

@Inheritance
@Entity
@DiscriminatorColumn
@Table(name = "registro_cnab")
abstract class RegistroCnabEntity : AbstractEntity() {
    var idCnab: String = ""
    var tipoRegistro: Int? = null
    var numeroSequencial: Int? = null

    @Column(columnDefinition = "varchar(10485760)")
    var registro: String? = null
}
