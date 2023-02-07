//package br.com.dhan.validacaocnab.application.validacao.service.impl
//
//import org.springframework.cache.annotation.CacheEvict
//import org.springframework.cache.annotation.Cacheable
//import org.springframework.scheduling.annotation.Scheduled
//
//class Testador {
//
//    fun teste() {
//        /*
//        primeiro registro pega os layoutmovimeento na API
//            e faz o cache do resultado
//        segundo registro ja pega do cache
//        terceiro...
//        finalizou o
//
//         */
//    }
//
//    @Service
//    class BuscadorDadosValidadoresService {
//
//        @Cacheable()
//        fun buscarCedentePorFundo(id: String, documentNumber: String) {
//            return cedentePort.findByIdFundoAndDocumentNumber(id, documentNumber)
//        }
//
//        @Cacheable()
//        fun findAllTiposByFundo(id: String) {
//            return fundoPort.findAllTiposBFundo(id, documentNumber)
//        }
//    }
//
//    class EvictDadosValidadores {
//
//        @Scheduled(executar meia noite)
//        @CacheEvict
//        fun buscarCedentePorFundoEvict() {
//
//        }
//    }
//}
