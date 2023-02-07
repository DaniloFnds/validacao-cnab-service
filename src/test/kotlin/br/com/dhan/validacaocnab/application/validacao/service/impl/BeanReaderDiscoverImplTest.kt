package br.com.dhan.validacaocnab.application.validacao.service.impl

import br.com.dhan.validacaocnab.BaseUtilTest
import br.com.dhan.validacaocnab.domain.cnab.Layout
import org.assertj.core.api.Assertions
import org.beanio.StreamFactory
import org.junit.jupiter.api.Test
import java.io.InputStreamReader

class BeanReaderDiscoverImplTest : BaseUtilTest() {

    @Test
    fun `Deve encontrar um bean reader para o layout`() {
        // setup
        val streamFactory = StreamFactory.newInstance()
        val beanio = this.javaClass.classLoader.getResourceAsStream("cnabExample.xml")!!
        streamFactory.load(beanio)
        val beanReaderDiscover = BeanReaderDiscoverImpl(streamFactory)

        // given
        val layout = Layout("cnab400Remessa", "descricao", "LAYOUT_400")
        val cnab = getFileFromResource("cnabs/CNAB_TEST_READ_LINES.txt")

        // when
        val discover = beanReaderDiscover.discover(layout, InputStreamReader(cnab))

        // then
        Assertions.assertThat(discover)
            .isNotNull
    }

    @Test
    fun `Deve ocorrer erro quando nao encontra o stream do layout`() {
        // setup
        val streamFactory = StreamFactory.newInstance()
        val beanio = this.javaClass.classLoader.getResourceAsStream("cnabExample.xml")!!
        streamFactory.load(beanio)
        val beanReaderDiscover = BeanReaderDiscoverImpl(streamFactory)

        // given
        val layout = Layout("cnab400RemessaNaoExiste", "descricao", "LAYOUT_400")
        val cnab = getFileFromResource("cnabs/CNAB_TEST_READ_LINES.txt")

        // when then
        Assertions.catchThrowable {
            beanReaderDiscover.discover(layout, InputStreamReader(cnab))
        }
    }
}
