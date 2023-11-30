package com.demo.dashboard.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class AppWebControll {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // permitir acesso de qualquer origem
        config.addAllowedOrigin("*");

        // acesso a todos os métodos (GET, POST, PUT, DELETE, etc.)
        config.addAllowedMethod("*");

        // permitir todos os cabeçalhos
        config.addAllowedHeader("*");

        // esta linha é para configurar o CORS globalmente para toda a aplicação
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
