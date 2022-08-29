package br.com.dhan.validacaocnab.infra.configuration.beanio.handlers

import br.com.dhan.lib.commons.extensions.removeCaracteresEspeciais
import org.beanio.types.ConfigurableTypeHandler
import org.beanio.types.TypeConversionException
import org.beanio.types.TypeHandler
import java.util.*

class StringCustomTypeHandler : ConfigurableTypeHandler {
    @Throws(TypeConversionException::class)
    override fun parse(text: String): Any {
        return text
    }

    override fun format(value: Any?): String? {
        return if (value != null) {
            (value as String).removeCaracteresEspeciais().uppercase(Locale.getDefault())
        } else null
    }

    override fun getType(): Class<*> {
        return String::class.java
    }

    @Throws(IllegalArgumentException::class)
    override fun newInstance(properties: Properties): TypeHandler? {
        return null
    }
}
