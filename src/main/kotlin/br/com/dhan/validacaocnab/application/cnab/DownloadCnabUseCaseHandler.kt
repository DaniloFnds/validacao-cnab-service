package br.com.dhan.validacaocnab.application.cnab

import br.com.dhan.validacaocnab.application.cnab.usecase.DownloadCnabUseCase
import org.springframework.stereotype.Service
import org.springframework.util.StreamUtils
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Paths

@Service
class DownloadCnabUseCaseHandler {

    fun handle(useCase: DownloadCnabUseCase): InputStream {
        /*
        se está no bucket
         bucket s3- get: useCase.path
         senao
         fileInput(useCase.path)
         */
       return if (useCase.bucket) {
            StreamUtils.emptyInput()
        } else Files.newInputStream(Paths.get(useCase.path))
    }
}
