package com.bngferoz.messagebroker.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class OpenApiConfig {

    @Value("${spring.application.name}")
    private String serviceName;

    @Bean
    public OpenAPI apiInfo() {
    	final String securitySchemeName = "MQ Service";
        return new OpenAPI().addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new Components().addSecuritySchemes(securitySchemeName, new SecurityScheme()
                        .name(securitySchemeName)
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")))
                .info(new Info()
                        .title(serviceName)
                        .version("v1.0")
                        .description("MQ Service Version 1.0")
                        .termsOfService(null)
                        .license(getLicense()));
    }

    private License getLicense() {
        License license = new License();
        license.setName("mqservice");
        license.setUrl("#");
        return license;
    }
}


