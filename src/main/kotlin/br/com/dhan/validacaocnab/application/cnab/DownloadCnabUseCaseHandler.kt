package br.com.dhan.validacaocnab.application.cnab

import br.com.dhan.validacaocnab.application.cnab.usecase.CnabCreateUseCase
import br.com.dhan.validacaocnab.application.cnab.usecase.DownloadCnabUseCase
import org.springframework.stereotype.Service
import java.io.File
import java.io.FileInputStream

@Service
class DownloadCnabUseCaseHandler {

    fun handle(downloadCnabUseCase: DownloadCnabUseCase): CnabCreateUseCase {
        // buscar na s3 OU storage ou anywhere
        //
        return CnabCreateUseCase(
            downloadCnabUseCase.idArquivo,
            downloadCnabUseCase.idFundo,
            downloadCnabUseCase.nome,
//            FileInputStream(File("C:/20210602_112329_20482021060003 - Copia.txt"))
            FileInputStream(File("C:/20210602_112329_20482021060003.txt"))
        )
    }
}
