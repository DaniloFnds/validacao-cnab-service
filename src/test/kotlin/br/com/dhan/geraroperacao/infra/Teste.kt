package br.com.dhan.geraroperacao.infra

import br.com.dhan.geraroperacao.Application
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.stereotype.Service
import org.springframework.test.context.ContextConfiguration

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [Application::class])
class Teste {

    @Autowired
    lateinit var apiRelatorio: ApiRelatorio<String, String>

    @Test
    fun teste() {


        println()



    }
}

interface ApiRelatorio<in PARAMETRO, out RETORNO> {
    fun call(parametro: PARAMETRO): RETORNO
}


@Service
class ChamadaRelatorioCarteira : ApiRelatorio<String, String> {

    override fun call(parametro: String): String {
        return "parameetro: $parametro"
    }
}
