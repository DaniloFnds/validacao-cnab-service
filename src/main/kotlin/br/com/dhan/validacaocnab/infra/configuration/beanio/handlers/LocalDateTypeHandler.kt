package br.com.dhan.validacaocnab.infra.configuration.beanio.handlers

import org.beanio.BeanIOException
import org.beanio.types.ConfigurableTypeHandler
import org.beanio.types.TypeConversionException
import org.beanio.types.TypeHandler
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class LocalDateTypeHandler : ConfigurableTypeHandler {
    lateinit var format: String

    constructor() {
    }

    constructor(format: String) {
        this.format = format
    }

    @Throws(TypeConversionException::class)
    override fun parse(text: String?): LocalDate? {
        return text?.run {
            LocalDate.parse(text, DateTimeFormatter.ofPattern(format))
        }
    }

    override fun format(value: Any): String {
        return (value as LocalDate).toString()
    }

    override fun getType(): Class<*> {
        return LocalDate::class.java
    }

    @Throws(IllegalArgumentException::class)
    override fun newInstance(properties: Properties): TypeHandler {
        val format = properties.getProperty("format") ?: throw BeanIOException("propriedade format nao informado")
        return LocalDateTypeHandler(format)
    }
}
