package br.com.dhan.validacaocnab.application.validacao.service

import br.com.dhan.validacaocnab.domain.cnab.Layout
import org.beanio.BeanReader
import java.io.Reader

interface BeanReaderDiscover {
    fun discover(layout: Layout, reader: Reader): BeanReader
}
