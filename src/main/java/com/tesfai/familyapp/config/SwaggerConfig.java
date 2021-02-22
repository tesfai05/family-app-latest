package com.tesfai.familyapp.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.tesfai.familyapp"))
				.paths(PathSelectors.any())
				// .paths(PathSelectors.regex("/api/*"))
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Family APPLICATION", 
				"Implementation of Family API August 2020", 
				"Version v1.0.0",
				"Terms of service", 
				new Contact("Tesfai", "www.tesfai.com", "tesfai1206@gmail.com"), 
				"License 1.0.0",
				"www.miu.edu", 
				Collections.emptyList());
	}

}
