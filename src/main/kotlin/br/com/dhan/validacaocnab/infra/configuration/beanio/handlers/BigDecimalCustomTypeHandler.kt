package br.com.dhan.validacaocnab.infra.configuration.beanio.handlers

import org.beanio.types.BigDecimalTypeHandler
import org.beanio.types.ConfigurableTypeHandler
import org.beanio.types.TypeConversionException
import org.beanio.types.TypeHandler
import java.math.BigDecimal
import java.util.*

class BigDecimalCustomTypeHandler : ConfigurableTypeHandler {
    private val handler: BigDecimalTypeHandler

    constructor() {
        handler = BigDecimalTypeHandler()
    }

    constructor(handler: BigDecimalTypeHandler) {
        this.handler = handler
    }

    @Throws(TypeConversionException::class)
    override fun parse(text: String): Any? {
        if (text == null || text.trim { it <= ' ' }.isEmpty()) {
            return null
        }
        var value: BigDecimal? = null
        value = try {
            handler.parse(text) as BigDecimal
        } catch (e: TypeConversionException) {
            throw TypeConversionException("O conteúdo do campo deve ser numérico.")
        }
        if (value != null) {
            value = value.divide(ONE_HUNDRED)
        }
        return value!!
    }

    override fun format(value: Any): String {
        if (value != null && value is BigDecimal) {
            var bg = value
            bg = bg.multiply(ONE_HUNDRED)
            return handler.format(bg)
        }
        return handler.format(value)
    }

    override fun getType(): Class<*> {
        return handler.type
    }

    @Throws(IllegalArgumentException::class)
    override fun newInstance(properties: Properties): TypeHandler {
        return BigDecimalCustomTypeHandler(handler.newInstance(properties) as BigDecimalTypeHandler)
    }

    companion object {
        private val ONE_HUNDRED = BigDecimal(100L)
    }
}
