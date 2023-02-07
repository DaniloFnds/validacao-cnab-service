package br.com.dhan.validacaocnab.application.validacao.service.impl

import br.com.dhan.validacaocnab.application.validacao.service.BeanReaderDiscover
import br.com.dhan.validacaocnab.commons.exceptions.StreamNotConfiguredException
import br.com.dhan.validacaocnab.domain.cnab.Layout
import org.beanio.BeanReader
import org.beanio.StreamFactory
import org.springframework.stereotype.Service
import java.io.Reader

@Service
class BeanReaderDiscoverImpl(
    private val streamFactory: StreamFactory
) : BeanReaderDiscover {

    override fun discover(layout: Layout, reader: Reader): BeanReader {
        try {
            return streamFactory.createReader(layout.stream, reader)
        } catch (ex: RuntimeException) {
            throw StreamNotConfiguredException("stream not found by layout $layout")
        }
    }
}
