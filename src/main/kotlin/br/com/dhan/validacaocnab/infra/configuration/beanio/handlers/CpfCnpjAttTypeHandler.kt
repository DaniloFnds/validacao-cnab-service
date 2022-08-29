package br.com.dhan.validacaocnab.infra.configuration.beanio.handlers

import br.com.dhan.lib.commons.documento.CpfCnpjUtils.isCpfOrCnpj
import org.beanio.types.TypeConversionException
import org.beanio.types.TypeHandler

class CpfCnpjAttTypeHandler : TypeHandler {

    @Throws(TypeConversionException::class)
    override fun parse(s: String?): Any =
        s?.takeIf {
            it.isCpfOrCnpj()
        } ?: throw TypeConversionException(String.format("Número de CPF/CNPJ inválido: '%s'", s))

    override fun format(o: Any): String {
        return o.toString()
    }

    override fun getType(): Class<*> {
        return String::class.java
    }
}
