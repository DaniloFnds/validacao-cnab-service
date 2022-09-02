package br.com.dhan.validacaocnab.application.validacao

import br.com.dhan.validacaocnab.application.cnab.DownloadCnabUseCaseHandler
import br.com.dhan.validacaocnab.application.cnab.usecase.DownloadCnabUseCase
import br.com.dhan.validacaocnab.application.cnab.usecase.toDomain
import br.com.dhan.validacaocnab.application.layout.LayoutDiscoverHandler
import br.com.dhan.validacaocnab.application.layout.usecase.LayoutRetrieveUseCase
import br.com.dhan.validacaocnab.application.registro.ArquivoCnabCreateUseCaseHandler
import br.com.dhan.validacaocnab.application.registro.usecase.ArquivoCreate
import br.com.dhan.validacaocnab.application.validacao.service.ProcessamentoValidacao
import br.com.dhan.validacaocnab.application.validacao.usecase.ValidacaoCreateUseCase
import br.com.dhan.validacaocnab.domain.registro.ArquivoCnab
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service
import kotlin.system.measureTimeMillis
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@Service
class ValidacaoHandler(
    private val downloadCnabUseCaseHandler: DownloadCnabUseCaseHandler,
    private val layoutDiscoverHandler: LayoutDiscoverHandler,
    private val processamentoValidacao: ProcessamentoValidacao,
    private val arquivoCnabCreateUseCaseHandler: ArquivoCnabCreateUseCaseHandler
) {

    @OptIn(ExperimentalTime::class)
    fun handler(validacaoCreateUseCase: ValidacaoCreateUseCase) = measureTime {
        runBlocking(Dispatchers.Default) {
            runCatching {
                val cnab = async { downloadCnabUseCaseHandler.handle(validacaoCreateUseCase.buildDownloadCnab()) }
                val layout = async { layoutDiscoverHandler.handler(validacaoCreateUseCase.buildLayoutRetrieve()) }
                val arquivoProcessado = async {
                    processamentoValidacao.processar(layout.await(), cnab.await().toDomain())
                }

                arquivoCnabCreateUseCaseHandler.handler(arquivoProcessado.await().toCreateUseCase())
            }
        }
    }.also {
        println("ValidacaoHandler.handler: ${it.inWholeSeconds}")
    }
}

private fun ArquivoCnab.toCreateUseCase() = ArquivoCreate(
    id = this.idArquivo,
    idFundo = this.idFundo,
    nome = this.nome,
    totalInvalidos = this.totalInvalidos,
    totalValidos = this.totalValidos,
    totalRegistros = this.totalRegistros
)

private fun ValidacaoCreateUseCase.buildDownloadCnab() = DownloadCnabUseCase(
    this.idArquivo,
    this.nomeArquivo,
    this.idFundo
)

private fun ValidacaoCreateUseCase.buildLayoutRetrieve() = LayoutRetrieveUseCase(
    this.idFundo
)
