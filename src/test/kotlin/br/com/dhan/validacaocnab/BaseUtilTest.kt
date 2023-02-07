package br.com.dhan.validacaocnab

abstract class BaseUtilTest {

    fun getFileFromResource(pathToFile: String) =
        this.javaClass.classLoader.getResourceAsStream(pathToFile)!!
}
