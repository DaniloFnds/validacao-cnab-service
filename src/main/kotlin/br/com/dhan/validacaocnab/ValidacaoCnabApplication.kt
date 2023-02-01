package br.com.dhan.validacaocnab

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.FeignClient

@SpringBootApplication
@FeignClient
class ValidacaoCnabApplication

fun main(args: Array<String>) {
    runApplication<ValidacaoCnabApplication>(*args)
}
