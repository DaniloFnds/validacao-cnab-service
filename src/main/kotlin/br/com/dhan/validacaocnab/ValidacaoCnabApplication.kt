package br.com.dhan.validacaocnab

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients(value = ["br.com.dhan.*.infra"])
class ValidacaoCnabApplication

fun main(args: Array<String>) {
    runApplication<ValidacaoCnabApplication>(*args)
}
