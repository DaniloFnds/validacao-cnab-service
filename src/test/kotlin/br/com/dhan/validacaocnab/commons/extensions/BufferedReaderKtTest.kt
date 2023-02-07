package br.com.dhan.validacaocnab.commons.extensions

import br.com.dhan.validacaocnab.BaseUtilTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.io.InputStreamReader

class BufferedReaderKtTest : BaseUtilTest() {

    @Test
    fun `Should get lines from file`() {
        // given
        val example = getFileFromResource("cnabs/CNAB_TEST_READ_LINES.txt")

        // and
        val buffered = InputStreamReader(example).buffered()

        // when
        val lines = buffered.getLines(3)

        // then
        Assertions.assertThat(lines)
            .hasSize(3)
            .first()
            .isEqualTo("HASSSSSSSSSSSSSSSSSSSSSSSAKWOIEUIQOJU SADFJKLSAJFDKAS   SDJFKLASDJFKASJ   SADJFKLASJDF")
    }
}
