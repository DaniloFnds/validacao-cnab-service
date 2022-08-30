package br.com.dhan.validacaocnab.infra.configuration

import org.beanio.StreamFactory
import org.beanio.spring.BeanIOStreamFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import org.springframework.core.io.support.ResourcePatternUtils

@Configuration
class FlatFileConfig(
    private val resourceLoader: ResourceLoader
) {

    @Bean
    fun streamFacotry(): StreamFactory {
        val streamFactory = BeanIOStreamFactory()
        streamFactory.setStreamMappings(loadResources())
        return streamFactory.getObject() ?: throw RuntimeException("there is a problem in setting stream mapping for Beanio")
    }

    private fun loadResources(): List<Resource> {
        val cnabsSub = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath:beanio/cnabs/*/*.xml")
        val cnabs = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath:beanio/cnabs/*.xml")
        return (cnabsSub + cnabs).toList()
    }
}
