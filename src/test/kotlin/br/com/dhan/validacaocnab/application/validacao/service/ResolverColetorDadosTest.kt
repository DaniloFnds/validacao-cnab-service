package br.com.dhan.validacaocnab.application.validacao.service

import br.com.dhan.validacaocnab.application.validacao.service.impl.coletor.model.SaidaColetor
import br.com.dhan.validacaocnab.domain.cnab.Layout
import br.com.dhan.validacaocnab.domain.layout.LayoutPorCodigoEnum
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class ResolverColetorDadosTest {

    @Test
    fun `Deve resolver o coletor e devolver o resultado`() {
        val coletor = object : ColetorDados<SaidaColetor> {
            override fun layout(): Set<LayoutPorCodigoEnum> {
                return setOf(LayoutPorCodigoEnum.LAYOUT_400)
            }

            override fun coletar(): SaidaColetor {
                return object : SaidaColetor {
                    private val resultado: String = "ok"
                }
            }
        }

        val layout = Layout("cnab400", "descricao", "LAYOUT_400")

        val listColetores = listOf<ColetorDados<SaidaColetor>>(
            coletor
        )

        val resolverColetorDados = ResolverColetorDados(
            listColetores
        )

        val resolve = resolverColetorDados.resolve(layout)
        val saidaColetor = resolve.coletar()

        Assertions.assertThat(resolve)
            .isNotNull

        Assertions.assertThat(saidaColetor)
            .isNotNull
            .extracting("resultado")
            .isEqualTo("ok")
    }

    @Test
    fun `Deve ocorrer erro quando nao encontrar um coletor para o layout`() {
        val coletor = object : ColetorDados<SaidaColetor> {
            override fun layout(): Set<LayoutPorCodigoEnum> {
                return setOf(LayoutPorCodigoEnum.LAYOUT_400)
            }

            override fun coletar(): SaidaColetor {
                return object : SaidaColetor {
                    private val resultado: String = "ok"
                }
            }
        }

        val layout = Layout("cnab400", "descricao", "LAYOUT_500")

        val listColetores = listOf<ColetorDados<SaidaColetor>>(
            coletor
        )

        val resolverColetorDados = ResolverColetorDados(
            listColetores
        )

        Assertions.catchThrowable {
            resolverColetorDados.resolve(layout)
        }
    }
}
