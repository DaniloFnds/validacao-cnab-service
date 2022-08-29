package br.com.dhan.validacaocnab.infra.configuration.beanio.handlers

import org.beanio.types.ConfigurableTypeHandler
import org.beanio.types.IntegerTypeHandler
import org.beanio.types.TypeConversionException
import org.beanio.types.TypeHandler
import java.util.*

class IntegerCustomTypeHandler : ConfigurableTypeHandler {
    private val handler: IntegerTypeHandler

    constructor() {
        handler = IntegerTypeHandler()
    }

    constructor(handler: IntegerTypeHandler) {
        this.handler = handler
    }

    @Throws(TypeConversionException::class)
    override fun parse(text: String): Any {
        return try {
            (if (text != null) handler.parse(text.trim { it <= ' ' }) else null)!!
        } catch (e: TypeConversionException) {
            throw TypeConversionException("O conteúdo do campo deve ser numérico.")
        }
    }

    override fun format(value: Any): String {
        return handler.format(value)
    }

    override fun getType(): Class<*> {
        return handler.type
    }

    @Throws(IllegalArgumentException::class)
    override fun newInstance(properties: Properties): TypeHandler {
        return IntegerCustomTypeHandler(handler.newInstance(properties) as IntegerTypeHandler)
    }
}
