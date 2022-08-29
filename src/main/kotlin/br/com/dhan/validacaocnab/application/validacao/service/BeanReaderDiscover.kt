package br.com.dhan.validacaocnab.application.validacao.service

import br.com.dhan.validacaocnab.domain.layout.Layout
import org.beanio.BeanReader
import java.io.InputStream

interface BeanReaderDiscover {
    fun discover(layout: Layout, inputFile: InputStream): BeanReader
}
