package com.sicpp.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI sicppOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SICPP API")
                        .description("API do sistema SICPP")
                        .version("v1"));
    }
}
