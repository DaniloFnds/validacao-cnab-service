package br.com.dhan.validacaocnab.commons.exceptions

class FailedValidatigCnabException(override val message: String? = "failed validating cnab") : RuntimeException(message)
