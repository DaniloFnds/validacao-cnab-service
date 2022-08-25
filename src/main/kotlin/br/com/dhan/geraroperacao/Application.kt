package br.com.dhan.geraroperacao

import br.com.dhan.geraroperacao.application.ApiRelatorio
import br.com.dhan.geraroperacao.application.RetornoRelatorio
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application : ApplicationRunner {

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
