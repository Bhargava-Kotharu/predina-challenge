package com.predina.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * Created By @author Bhargava Kotharu on 02 August, 2018
 *
 */
@EnableSwagger2
@SpringBootApplication
public class PredinaApplication {

    public static void main(String[] args) {
	SpringApplication.run(PredinaApplication.class, args);
    }

    @Bean
    public Docket docket() {
	return new Docket(DocumentationType.SWAGGER_2).select()
		.apis(RequestHandlerSelectors.basePackage(getClass().getPackage().getName())).paths(PathSelectors.any())
		.build().apiInfo(generateApiInfo());
    }

    private ApiInfo generateApiInfo() {
	return new ApiInfoBuilder().title("Predina Coding Challenge").description("Evaluation Test").version("1.0.0")
		.build();
    }

}
