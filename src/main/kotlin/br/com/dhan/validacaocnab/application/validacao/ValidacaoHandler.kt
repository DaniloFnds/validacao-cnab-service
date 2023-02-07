package br.com.dhan.validacaocnab.application.validacao

import br.com.dhan.validacaocnab.application.cnab.ArquivoCnabCreateUseCaseHandler
import br.com.dhan.validacaocnab.application.cnab.DownloadCnabUseCaseHandler
import br.com.dhan.validacaocnab.application.cnab.usecase.DownloadCnabUseCase
import br.com.dhan.validacaocnab.application.layout.LayoutDiscoverHandler
import br.com.dhan.validacaocnab.application.validacao.service.ProcessamentoValidacao
import br.com.dhan.validacaocnab.application.validacao.usecase.ValidationCreateUseCase
import br.com.dhan.validacaocnab.domain.cnab.Cnab
import org.springframework.stereotype.Service
import java.io.StringReader

@Service
class ValidacaoHandler(
    private val downloadCnabUseCaseHandler: DownloadCnabUseCaseHandler,
    private val layoutDiscoverHandler: LayoutDiscoverHandler,
    private val processamentoValidacao: ProcessamentoValidacao,
    private val arquivoCnabCreateUseCaseHandler: ArquivoCnabCreateUseCaseHandler
) {

    fun handler(validationCreateUseCase: ValidationCreateUseCase) =
        runCatching {
            val downloadedCnabStream = downloadCnabUseCaseHandler.handle(validationCreateUseCase.toDownloadCnab())

            val arquivoProcessado =
                processamentoValidacao.processar(
                    Cnab(
                        documentNumberFundo = validationCreateUseCase.documentNumberFundo,
                        name = validationCreateUseCase.fileName,
                        file = StringReader("asd")
                    )
                )

//            arquivoCnabCreateUseCaseHandler.handler(arquivoProcessado.toCreateUseCase())
        }
}

private fun ValidationCreateUseCase.toDownloadCnab() =
    DownloadCnabUseCase(
        this.bucket,
        this.filePath
    )
