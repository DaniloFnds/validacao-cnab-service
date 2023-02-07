package br.com.dhan.validacaocnab.infra.configuration.filters

import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class LogRequestFilter : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        println("todo colocar o log URL chamada: ${request.method} ${request.requestURI} ${request.contentType}")
        filterChain.doFilter(request, response)
    }
}
