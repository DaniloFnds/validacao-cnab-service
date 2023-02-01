package br.com.dhan.validacaocnab.infra.adapters.registro.jpa.repository

import br.com.dhan.validacaocnab.infra.adapters.registro.jpa.entity.RegistroCnabEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RegistroCnabRepository : JpaRepository<RegistroCnabEntity, String>
