package br.com.dhan.validacaocnab.infra.validacao.event

import br.com.dhan.validacaocnab.application.validacao.ValidacaoHandler
import br.com.dhan.validacaocnab.application.validacao.usecase.ValidationCreateUseCase
import br.com.dhan.validacaocnab.infra.validacao.event.dto.ValidacaoEvent
import org.springframework.stereotype.Component
import java.util.function.Consumer

@Component("validacaoEventConsumer")
class ValidacaoEventConsumer(
    private val validacaoHandler: ValidacaoHandler
) : Consumer<ValidacaoEvent> {

    override fun accept(validacaoEvent: ValidacaoEvent) {
        validacaoHandler.handler(validacaoEvent.toCreateUseCase())
    }
}

private fun ValidacaoEvent.toCreateUseCase() = ValidationCreateUseCase(
    this.documentNumberFundo,
    this.bucket,
    this.fileName,
    this.filePath,
    this.userNameRequested
)
