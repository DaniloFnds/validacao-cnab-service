package br.com.dhan.geraroperacao.samples;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class Testador2 {


    @Test
    void name() {




    }


    public interface Relatorio<PARAMETRO extends ITipoRelatorio, RETORNO> {

        RETORNO gerar(PARAMETRO parametro);
    }


    public class RelatorioImpl implements Relatorio<ParametroRelatorioEstoqueCsv, RetornoRelatorioEstoque> {

        @Override
        public RetornoRelatorioEstoque gerar(ParametroRelatorioEstoqueCsv parametroRelatorioEstoqueCsv) {
            Integer idFundo = parametroRelatorioEstoqueCsv.getIdFundo();
            return null;
        }
    }


    public class ParametroRelatorioEstoqueCsv implements ITipoRelatorio {
        private Integer idFundo;
        private LocalDate dataFundo;

        @Override
        public TipoRelatorioEnum tipo() {
            return TipoRelatorioEnum.CSV;
        }

        public Integer getIdFundo() {
            return idFundo;
        }

        public void setIdFundo(Integer idFundo) {
            this.idFundo = idFundo;
        }

        public LocalDate getDataFundo() {
            return dataFundo;
        }

        public void setDataFundo(LocalDate dataFundo) {
            this.dataFundo = dataFundo;
        }
    }

    public class ParametroRelatorioEstoquePdf implements ITipoRelatorio {
        private Integer idFundo;
        private LocalDate dataFundo;

        @Override
        public TipoRelatorioEnum tipo() {
            return TipoRelatorioEnum.PDF;
        }
    }

    public class RetornoRelatorioEstoque {

    }

    public interface ITipoRelatorio {
        TipoRelatorioEnum tipo();
    }

    public enum TipoRelatorioEnum {
        CSV, PDF
    }


}



