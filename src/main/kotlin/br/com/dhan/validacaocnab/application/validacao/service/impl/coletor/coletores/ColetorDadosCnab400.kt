package br.com.dhan.validacaocnab.application.validacao.service.impl.coletor.coletores

import br.com.dhan.validacaocnab.application.validacao.service.ColetorDados
import br.com.dhan.validacaocnab.application.validacao.service.impl.coletor.model.cnab400.SaidaCnab400Coletor
import br.com.dhan.validacaocnab.domain.layout.LayoutPorCodigoEnum
import br.com.dhan.validacaocnab.domain.layout.LayoutPorCodigoEnum.LAYOUT_400
import br.com.dhan.validacaocnab.domain.layout.LayoutPorCodigoEnum.LAYOUT_440
import org.springframework.stereotype.Service

@Service
class ColetorDadosCnab400 : ColetorDados<SaidaCnab400Coletor> {
    override fun layout(): Set<LayoutPorCodigoEnum> {
        return setOf(LAYOUT_400, LAYOUT_440)
    }

    override fun coletar(): SaidaCnab400Coletor {
        // fazer todas as consultas para a saida cnab coletor
        return SaidaCnab400Coletor()
    }
}
