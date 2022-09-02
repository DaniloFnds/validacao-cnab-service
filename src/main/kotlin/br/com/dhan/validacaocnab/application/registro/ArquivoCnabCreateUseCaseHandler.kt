package br.com.dhan.validacaocnab.application.registro

import br.com.dhan.validacaocnab.application.registro.usecase.ArquivoCreate
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ArquivoCnabCreateUseCaseHandler {

    fun handler(arquivoCreate: ArquivoCreate) {
        println("chegou $arquivoCreate - hora: ${LocalDateTime.now()}")
    }
}
