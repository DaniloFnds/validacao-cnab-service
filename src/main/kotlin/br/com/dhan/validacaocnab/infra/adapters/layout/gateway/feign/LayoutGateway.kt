package br.com.dhan.validacaocnab.infra.adapters.layout.gateway.feign

import br.com.dhan.validacaocnab.infra.adapters.layout.gateway.dto.FindLayoutRequest
import br.com.dhan.validacaocnab.infra.adapters.layout.gateway.dto.LayoutResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(
    name = "layout-service",
    url = "\${feign.client.config.layout-service.url}"
)
interface LayoutGateway {

    @PostMapping("/api/v1/layouts/search/fundo/registros")
    fun findLayout(@RequestBody findLayoutRequest: FindLayoutRequest): LayoutResponse
}
