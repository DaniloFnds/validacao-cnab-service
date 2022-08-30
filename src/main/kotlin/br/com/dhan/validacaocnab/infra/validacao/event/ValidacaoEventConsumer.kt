package br.com.dhan.validacaocnab.infra.validacao.event

import br.com.dhan.schema.validacao.ValidacaoEvent
import br.com.dhan.validacaocnab.application.validacao.ValidacaoHandler
import br.com.dhan.validacaocnab.application.validacao.usecase.ValidacaoCreateUseCase
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

private fun ValidacaoEvent.toCreateUseCase() = ValidacaoCreateUseCase(
    idArquivo = this.idArquivo,
    idFundo = this.idFundo,
    nomeArquivo = this.nome
)
