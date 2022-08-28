package br.com.dhan.geraroperacao.application.validacao.service.impl.processamento

import br.com.dhan.geraroperacao.application.validacao.service.ProcessamentoValidacao
import br.com.dhan.geraroperacao.domain.cnab.Cnab
import br.com.dhan.geraroperacao.domain.layout.Layout
import org.beanio.StreamFactory
import org.springframework.stereotype.Service
import java.nio.charset.Charset

@Service
class ProcessamentoValidacaoImpl(
    private val streamFactory: StreamFactory
) : ProcessamentoValidacao {

    override fun processar(layout: Layout, cnab: Cnab) {
        runCatching {
            val createReader = streamFactory.createReader(layout.stream, cnab.inputFile.reader(Charset.defaultCharset()))


        }

        /*
            cada layout tenha a sua lista de validacoes
            entao 400, tem 5 validacoes de tail e 2 dew header



            ###
            pega o byte do arquivo
            cria o beanreader
            coleta todos os dados para validar
            encontra o validadorLayout, junto com a sua lista de validacoes
            para cada registro,chamador validadorLayout passando o registro
                *validadorLayout
                    pega a lista da validacoes
                    para vada validacao aplica no registro
                    grava se o registro é invalido






         */
    }
}
