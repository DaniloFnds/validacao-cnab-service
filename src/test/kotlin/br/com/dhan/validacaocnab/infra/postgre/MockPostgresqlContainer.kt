package br.com.dhan.validacaocnab.infra.postgre

import org.testcontainers.containers.PostgreSQLContainer

object MockPostgresqlContainer : PostgreSQLContainer<MockPostgresqlContainer>("postgres") {
    override fun start() {
        super.start()
        System.setProperty("DATABASE_URL", this.jdbcUrl)
        System.setProperty("DATABASE_PASSWORD", this.username)
        System.setProperty("DATABASE_USERNAME", this.password)
    }
}
