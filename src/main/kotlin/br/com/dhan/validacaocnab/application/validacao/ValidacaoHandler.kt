package br.com.dhan.validacaocnab.application.validacao

import br.com.dhan.validacaocnab.application.cnab.DownloadCnabUseCaseHandler
import br.com.dhan.validacaocnab.application.cnab.usecase.DownloadCnabUseCase
import br.com.dhan.validacaocnab.application.cnab.usecase.toDomain
import br.com.dhan.validacaocnab.application.layout.LayoutDiscoverHandler
import br.com.dhan.validacaocnab.application.layout.usecase.LayoutRetrieveUseCase
import br.com.dhan.validacaocnab.application.validacao.service.ProcessamentoValidacao
import br.com.dhan.validacaocnab.application.validacao.usecase.ValidacaoCreateUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ValidacaoHandler(
    private val downloadCnabUseCaseHandler: DownloadCnabUseCaseHandler,
    private val layoutDiscoverHandler: LayoutDiscoverHandler,
    private val processamentoValidacao: ProcessamentoValidacao
) {

    fun handler(validacaoCreateUseCase: ValidacaoCreateUseCase) = runBlocking(Dispatchers.Default) {
        runCatching {
            val cnab = async { downloadCnabUseCaseHandler.handle(validacaoCreateUseCase.buildDownloadCnab()) }
            val layout = async { layoutDiscoverHandler.handler(validacaoCreateUseCase.buildLayoutRetrieve()) }
            launch {
                processamentoValidacao.processar(layout.await(), cnab.await().toDomain())
            }
        }
    }
}

private fun ValidacaoCreateUseCase.buildDownloadCnab() = DownloadCnabUseCase(
    this.idArquivo,
    this.nomeArquivo,
    this.idFundo
)

private fun ValidacaoCreateUseCase.buildLayoutRetrieve() = LayoutRetrieveUseCase(
    this.idFundo
)
