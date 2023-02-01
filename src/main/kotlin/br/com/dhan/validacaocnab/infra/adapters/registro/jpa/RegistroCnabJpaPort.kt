package br.com.dhan.validacaocnab.infra.adapters.registro.jpa

import br.com.dhan.lib.commons.metrics.timedDBOps
import br.com.dhan.validacaocnab.application.registro.port.RegistroCnabPort
import br.com.dhan.validacaocnab.domain.registro.RegistroCnab
import br.com.dhan.validacaocnab.domain.registro.RegistroCnabDetail
import br.com.dhan.validacaocnab.domain.registro.RegistroCnabHeader
import br.com.dhan.validacaocnab.domain.registro.RegistroCnabTrailer
import br.com.dhan.validacaocnab.infra.adapters.registro.jpa.entity.RegistroCnabDetailEntity
import br.com.dhan.validacaocnab.infra.adapters.registro.jpa.entity.RegistroCnabEntity
import br.com.dhan.validacaocnab.infra.adapters.registro.jpa.entity.RegistroCnabHeaderEntity
import br.com.dhan.validacaocnab.infra.adapters.registro.jpa.entity.RegistroCnabTrailerEntity
import br.com.dhan.validacaocnab.infra.adapters.registro.jpa.repository.RegistroCnabRepository
import io.micrometer.core.instrument.MeterRegistry
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Component
import kotlin.system.measureTimeMillis

@Component
class RegistroCnabJpaPort(
    private val registroCnabRepository: RegistroCnabRepository,
    private val meterRegistry: MeterRegistry
) : RegistroCnabPort {

    override fun create(registros: List<RegistroCnabEntity>): String =
        meterRegistry.timedDBOps(this::class, "create:registroCnab") {
            registroCnabRepository.saveAll(registros)
            "asd"
        }


}
