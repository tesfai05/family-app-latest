package com.tesfai.familyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableCaching
@EnableAspectJAutoProxy
public class FamilyApplication {

	public static void main(String[] args) {
		System.out.println("========= MAIN =========");
		SpringApplication.run(FamilyApplication.class, args);
	}

}
