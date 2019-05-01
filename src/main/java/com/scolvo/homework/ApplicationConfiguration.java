package com.scolvo.homework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class ApplicationConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.scolvo.homework.web"))
                .build()
                .apiInfo(new ApiInfo(
                                "Scolvo.com HomeWork",
                                "Service to implement my home work",
                                "1.0",
                                null,
                                new Contact("Peter Kedevssy", null, "pkedvessy@gmail.com"),
                                "", "", Collections.emptyList()
                        )
                );
    }

}
