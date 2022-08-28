package br.com.dhan.geraroperacao.application.validacao.service

import br.com.dhan.geraroperacao.domain.layout.Layout
import org.beanio.BeanReader
import java.io.InputStream

interface BeanReaderDiscover {

    fun discover(layout: Layout, inputFile: InputStream): BeanReader
}
