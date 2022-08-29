package br.com.dhan.validacaocnab.infra.configuration

import org.beanio.StreamFactory
import org.beanio.spring.BeanIOStreamFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.Resource

@Configuration
class FlatFileConfig(
    @Value("classpath:/beanio/*.xml")
    private val streamMappings: List<Resource>
) {

    @Bean
    fun streamFacotry(): StreamFactory {
        val streamFactory = BeanIOStreamFactory()
        streamFactory.setStreamMappings(streamMappings)
        return streamFactory.getObject() ?: throw RuntimeException("there is a problem in setting stream mapping for Beanio")
    }
}
