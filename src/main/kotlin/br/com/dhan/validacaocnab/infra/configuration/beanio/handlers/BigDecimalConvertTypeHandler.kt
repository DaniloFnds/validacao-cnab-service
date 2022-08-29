package br.com.dhan.validacaocnab.infra.configuration.beanio.handlers

import br.com.dhan.lib.commons.extensions.removeCaracteresEspeciais
import org.beanio.types.BigDecimalTypeHandler
import org.beanio.types.ConfigurableTypeHandler
import org.beanio.types.TypeConversionException
import org.beanio.types.TypeHandler
import java.math.BigDecimal
import java.util.*

class BigDecimalConvertTypeHandler : ConfigurableTypeHandler {
    private val handler: BigDecimalTypeHandler
    private var removeCaracteresEspecial = false

    constructor() {
        handler = BigDecimalTypeHandler()
    }

    constructor(handler: BigDecimalTypeHandler) {
        this.handler = handler
    }

    constructor(removeCaracteresEspecial: Boolean) {
        handler = BigDecimalTypeHandler()
        this.removeCaracteresEspecial = removeCaracteresEspecial
    }

    @Throws(TypeConversionException::class)
    override fun parse(text: String?): BigDecimal? {
        return text?.run {
            handler.parse(this.replace(',', '.')) as BigDecimal
        } ?: BigDecimal.ZERO
    }

    override fun format(value: Any): String {
        return if (removeCaracteresEspecial) value.toString().removeCaracteresEspeciais() else handler.format(value)
    }

    override fun getType(): Class<*> {
        return handler.type
    }

    @Throws(IllegalArgumentException::class)
    override fun newInstance(properties: Properties): TypeHandler {
        return BigDecimalConvertTypeHandler(handler.newInstance(properties) as BigDecimalTypeHandler)
    }
}
