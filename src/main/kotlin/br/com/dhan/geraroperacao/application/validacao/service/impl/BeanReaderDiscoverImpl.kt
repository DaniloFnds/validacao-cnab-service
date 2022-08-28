package br.com.dhan.geraroperacao.application.validacao.service.impl

import br.com.dhan.geraroperacao.application.validacao.service.BeanReaderDiscover
import br.com.dhan.geraroperacao.commons.exceptions.StreamNotConfiguredException
import br.com.dhan.geraroperacao.domain.layout.Layout
import org.beanio.BeanReader
import org.beanio.StreamFactory
import org.springframework.stereotype.Service
import java.io.InputStream

@Service
class BeanReaderDiscoverImpl(
    private val streamFactory: StreamFactory
) : BeanReaderDiscover {

    override fun discover(layout: Layout, inputFile: InputStream): BeanReader {
        try {
            return streamFactory.createReader(layout.stream, inputFile.reader())
        } catch (ex: RuntimeException) {
            throw StreamNotConfiguredException()
        }
    }
}
