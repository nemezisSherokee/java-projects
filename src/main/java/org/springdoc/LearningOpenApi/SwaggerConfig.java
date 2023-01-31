package org.springdoc.LearningOpenApi;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class SwaggerConfig {

    /*
    User API
     */
    @Bean
    public GroupedOpenApi userApi() {
        final String[] packagesToScan = {"org.springdoc"};
        return GroupedOpenApi
                .builder()
                .group("User API")
                .packagesToScan(packagesToScan)
                .pathsToMatch("/users/**")
                .addOpenApiCustomiser(statusApiCostumizer())
                .build();
    }

    private OpenApiCustomiser statusApiCostumizer() {
        return openAPI -> openAPI
                .info(new Info()
                        .title("Springboot & OpenAPI")
                        .description("This is a sample Spring Boot RESTful service using OpenAPI")
                        .version("3.0.0")
                        .contact(new Contact()
                                .name("Razvan Prichici")
                                .url("https://github.com/essentialprogramming")
                                .email("razvanpaulp@gmail.com")));
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Contact Application API").description(
                        "This is a sample Spring Boot RESTful service using springdoc-openapi and OpenAPI 3."));
    }

}