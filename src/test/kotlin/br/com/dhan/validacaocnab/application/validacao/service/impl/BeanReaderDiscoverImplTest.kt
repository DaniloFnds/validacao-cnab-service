package br.com.dhan.validacaocnab.application.validacao.service.impl

import br.com.dhan.validacaocnab.domain.layout.Layout
import org.assertj.core.api.Assertions
import org.beanio.StreamFactory
import org.junit.jupiter.api.Test
import java.io.InputStream
import java.io.InputStreamReader
import java.io.StringReader

internal class BeanReaderDiscoverImplTest {

    @Test
    fun `Deve encontrar um bean reader para o layout`() {
        val streamFactory = StreamFactory.newInstance()
        val beanio = this.javaClass.classLoader.getResourceAsStream("cnabExample.xml")!!
        streamFactory.load(beanio)

        val layout = Layout("cnab400Remessa", "descricao", "LAYOUT_400")

        val beanReaderDiscover = BeanReaderDiscoverImpl(streamFactory)

        val discover = beanReaderDiscover.discover(layout, beanio)

        Assertions.assertThat(discover)
            .isNotNull
    }

    @Test
    fun `Deve ocorrer erro quando nao encontra o stream do layout`() {
        val streamFactory = StreamFactory.newInstance()
        val beanio = this.javaClass.classLoader.getResourceAsStream("cnabExample.xml")!!
        streamFactory.load(beanio)

        val layout = Layout("cnab400RemessaNaoExiste", "descricao", "LAYOUT_400")

        val beanReaderDiscover = BeanReaderDiscoverImpl(streamFactory)

        Assertions.catchException {
            beanReaderDiscover.discover(layout, beanio)
        }
    }
}
