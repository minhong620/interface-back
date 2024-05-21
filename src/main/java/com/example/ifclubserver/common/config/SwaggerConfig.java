package com.example.ifclubserver.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "Interface Club Management",
                description = "인터페이스 소모임 관리 시스템",
                version = "0.1v"))
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        SecurityScheme apiKey = new SecurityScheme()
            .type(SecurityScheme.Type.HTTP)
            .in(SecurityScheme.In.HEADER)
            .name("Authorization")
            .scheme("bearer")
            .bearerFormat("JWT");

        SecurityRequirement securityRequirement = new SecurityRequirement()
            .addList("Bearer Token");

        Server server1 = new Server().url("http://220.85.169.165:8084").description("Generated server url");
        Server server2 = new Server().url("http://localhost:8080").description("Local server");

        return new OpenAPI()
            .components(new Components().addSecuritySchemes("Bearer Token", apiKey))
            .addSecurityItem(securityRequirement)
            .servers(Arrays.asList(server1, server2));
    }
}
