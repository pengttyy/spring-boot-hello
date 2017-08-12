package com.pengttyy;

import com.pengttyy.domain.FooProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableConfigurationProperties(FooProperties.class)
public class SpringBootHelloApplication {

    @Bean
    public RestTemplate restTemplateBuild(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pengttyy"))
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("pengttyy", "http://localhost", "pengttyy@gmail.com");
        return new ApiInfoBuilder()
                .title("Spring Boot集成Swagger2")
                .description("Hello Swagger2")
                .contact(contact)
                .version("1.0")
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloApplication.class, args);
    }
}
