/*
package br.com.dhan.geraroperacao.samples

import io.mockk.mockk
import org.beanio.builder.FieldBuilder
import org.beanio.builder.RecordBuilder
import org.beanio.builder.StreamBuilder

class Testador {

    fun teste() {
        */
/*

        layout(cnab500).apply {
             tamanho(500)
            header("header1").apply {
                obrigatorio()
                campos() {
                   campo("identificacao do registro") {
                        inicio(1)
                        fim(1)
                        tamanho(1)
                        obrigatorio()
                        alphanumerico()//numerico(20/3/6..casasdecimais)
                        conteudo("remessa")
                        descricao()
                   },
                   campo("identificacao do registro") {
                        inicio(1)
                        fim(1)
                        tamanho(1)
                        obrigatorio()
                        alphanumerico()//numerico(20/3/6..casasdecimais)
                        conteudo("remessa")
                        descricao()
                   }

                }
                header("header2")

            }

        }

        fun camposHeader() : List<Campo> {
            return listof(
                campo("identificacao do registro") {
                        inicio(1)
                        fim(1)
                        tamanho(1)
                        obrigatorio()
                        alphanumerico()//numerico(20/3/6..casasdecimais)
                        conteudo("remessa")
                        descricao()
                   },
                   campo("identificacao do registro") {
                        inicio(1)
                        fim(1)
                        tamanho(1)
                        obrigatorio()
                        alphanumerico()//numerico(20/3/6..casasdecimais)
                        conteudo("remessa")
                        descricao()
                   }
            )
        }




         *//*


        val streamBuilder = StreamBuilder("cnab404", "fixedlength").apply {
            minOccurs(1)
            addRecord(
                RecordBuilder("header", Header::class.java).apply {
                    order(1)
                    occurs(1, 1)
                    addField(
                        FieldBuilder("literal").apply {
                            at(0)
                            length(2)
                            trim()
                            literal("P")
                        }
                    )
                }
            )
        }
        val mockk = mockk<Layout>() {
            tamanho(10)
        }

        val list: List<() -> Unit> = listOf({})

        val layout = Layout("cnab500").apply {
            tamanho(500)
            header("header1") {
                obrigatorio()
                campos(){

                }
            }
        }
    }

    val campo = Campo().apply {
        nome("nome")
        inicio(1)
        fim(1)
        obrigatorio()
        alphanumerico()
    }
}

class Layout(
    private val nome: String,
    private var tamanho: Int = 0,
    private var registro: Registro = Registro("")
) {

    fun tamanho(_tamanho: Int) {
        tamanho = _tamanho
    }

    fun header(_nome: String, block: Registro.() -> Unit): Registro {
        registro.nome(_nome)
        block(registro)
        return registro
    }
}

class Registro(
    private var nome: String,
    private var obrigatorio: Boolean = false,
    private var campos: MutableList<Campo> = mutableListOf()
) {

    fun nome(_nome: String) {
        nome = _nome
    }

    fun obrigatorio() {
        obrigatorio = true
    }

    fun campos(listCampos: List<() -> Campo>) {
        listCampos.forEach {
            campos.add(it())
        }
    }
}

class Campo(
    private var nome: String = "",
    private var inicio: Int = 0,
    private var fim: Int = 0,
    private var tamanho: Int = 0,
    private var obrigatorio: Boolean = false,
    private var alphanumerico: Boolean = false,
    private var numerico: TipoNumerico = TipoNumerico(0),
    private var conteudo: String = "",
    private var descricao: String = ""
) {
    fun nome(_nome: String) {
        nome = _nome
    }

    fun inicio(_inicio: Int) {
        inicio = _inicio
    }

    fun fim(_fim: Int) {
        fim = _fim
    }

    fun tamanho(_tamanho: Int) {
        tamanho = _tamanho
    }

    fun obrigatorio() {
        obrigatorio = true
    }

    fun alphanumerico() {
        alphanumerico = true
    }

    fun numerico(_numerico: Int) {
        numerico = TipoNumerico(_numerico)
    }

    fun conteudo(_conteudo: String) {
        conteudo = _conteudo
    }

    fun descricao(_descricao: String) {
        descricao = _descricao
    }
}

data class TipoNumerico(val decimais: Int)

data class Header(val literal: String, val nome: String)




































*/
