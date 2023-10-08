package com.jinnov.jinnovglobalapi.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("JINNOV Global API")
                        .description("""
                                This API is used to manage studies, clients, suppliers, and users at JINNOV, in order to provide a global view of the Junior-Enterprise.

                                This API is used by the JINNOV Global Frontend, which is a web application used by the JINNOV Global team to manage the Junior-Enterprise.""")
                        .version("1.0.0")
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/license/mit/"))
                        .contact(new Contact()
                                .name("JINNOV")
                                .email("contact@jinnov-insa.fr")
                                .url("https://jinnov-insa.fr/"))
                );
    }

    @Bean
    public GroupedOpenApi publicApi() {
        String[] paths = {"/api/**"};
        return GroupedOpenApi.builder()
                .group("public-api")
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi privateApi() {
        String[] paths = {"/api/**"};
        return GroupedOpenApi.builder()
                .group("private-api")
                .pathsToMatch(paths)
                .build();
    }
}
