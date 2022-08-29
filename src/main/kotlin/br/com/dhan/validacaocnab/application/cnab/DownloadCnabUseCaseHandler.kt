package br.com.dhan.validacaocnab.application.cnab

import br.com.dhan.validacaocnab.application.cnab.usecase.CnabCreateUseCase
import br.com.dhan.validacaocnab.application.cnab.usecase.DownloadCnabUseCase
import java.io.File
import java.io.FileInputStream

class DownloadCnabUseCaseHandler {

    fun handle(downloadCnabUseCase: DownloadCnabUseCase): CnabCreateUseCase {
        // buscar na s3 OU storage ou anywhere
        //
        return CnabCreateUseCase(
            downloadCnabUseCase.idArquivo,
            downloadCnabUseCase.idFundo,
            downloadCnabUseCase.nome,
            FileInputStream(File("C:/160817131139_TESTE.REM"))
        )
    }
}
