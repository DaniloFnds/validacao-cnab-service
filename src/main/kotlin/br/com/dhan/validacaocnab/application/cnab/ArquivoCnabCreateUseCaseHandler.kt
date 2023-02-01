package br.com.dhan.validacaocnab.application.cnab

import br.com.dhan.validacaocnab.application.cnab.usecase.ArquivoCreate
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ArquivoCnabCreateUseCaseHandler {

    fun handler(arquivoCreate: ArquivoCreate) {
        println("chegou $arquivoCreate - hora: ${LocalDateTime.now()}")
    }
}
