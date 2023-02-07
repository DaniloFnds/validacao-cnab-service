package br.com.dhan.validacaocnab.commons.extensions

import java.io.BufferedReader
import java.io.CharArrayReader

fun BufferedReader.getLines(until: Int): List<String> {
    val buffer = CharArray(8 * 1024)
    this.read(buffer)
    return CharArrayReader(buffer).readLines().take(until)
}
