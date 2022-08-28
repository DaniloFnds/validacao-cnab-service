package br.com.dhan.geraroperacao.application.validacao.service.impl.coletor

import br.com.dhan.geraroperacao.application.validacao.service.ColetorDados
import br.com.dhan.geraroperacao.application.validacao.service.impl.coletor.model.cnab400.EntradaCnab400Coletor
import br.com.dhan.geraroperacao.application.validacao.service.impl.coletor.model.cnab400.SaidaCnab400Coletor
import br.com.dhan.geraroperacao.domain.layout.LayoutPorCodigoEnum
import br.com.dhan.geraroperacao.domain.layout.LayoutPorCodigoEnum.LAYOUT_400
import br.com.dhan.geraroperacao.domain.layout.LayoutPorCodigoEnum.LAYOUT_440
import org.springframework.stereotype.Service

@Service
class ColetorDadosCnab400 : ColetorDados<SaidaCnab400Coletor, EntradaCnab400Coletor> {
    override fun layout(): Set<LayoutPorCodigoEnum> {
        return setOf(LAYOUT_400, LAYOUT_440)
    }

    override fun coletar(entrada: EntradaCnab400Coletor): SaidaCnab400Coletor {

    }
}
