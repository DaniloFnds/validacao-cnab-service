package br.com.dhan.validacaocnab.infra.adapters.registro.jpa

import br.com.dhan.lib.commons.metrics.timedDBOps
import br.com.dhan.validacaocnab.application.registro.port.RegistroCnabPort
import br.com.dhan.validacaocnab.infra.adapters.registro.jpa.entity.RegistroCnabEntity
import br.com.dhan.validacaocnab.infra.adapters.registro.jpa.repository.RegistroCnabRepository
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.stereotype.Component

@Component
class RegistroCnabJpaPort(
    private val registroCnabRepository: RegistroCnabRepository,
    private val meterRegistry: MeterRegistry
) : RegistroCnabPort {

    override fun create(registros: List<RegistroCnabEntity>): List<RegistroCnabEntity> =
        meterRegistry.timedDBOps(this::class, "create:registroCnab") {
            registroCnabRepository.saveAll(registros)
        }
}
