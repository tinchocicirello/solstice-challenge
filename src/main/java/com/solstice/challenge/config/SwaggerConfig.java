package com.solstice.challenge.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan("com.solstice.challenge.controller.v1")
public class SwaggerConfig {


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.solstice.challenge.controller.v1"))
                .paths(Predicates.not(PathSelectors.regex("/error")))
                .build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        String description = "REST API documentation for Solstice Backend Coding Challenge";
        return new ApiInfoBuilder()
                .title("Solstice Challenge REST API")
                .description(description)
                .contact(new Contact("Martin Cicirello","http://github.com/tinchocicirello",null))
                .version("1.0.0")
                .build();
    }
}


