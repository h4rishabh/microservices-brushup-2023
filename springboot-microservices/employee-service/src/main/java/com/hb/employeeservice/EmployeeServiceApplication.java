package com.hb.employeeservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring boot Rest API Documentation for Employee Service",
				description = "Spring boot Rest API Documentation for Employee Service",
				version = "v1.0",
				contact = @Contact(
						name = "Hrishabh",
						email = "email@gmail.com",
						url = "https://www.github.com/h4rishabh"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.github.com/h4rishabh/licences"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring boot Rest API Documentation for Employee Service",
				url = "https://github.com/h4rishabh/microservices-brushup-2023/tree/master/springboot-microservices/employee-service"
		)
)
@EnableFeignClients
public class EmployeeServiceApplication {

//	@Bean
//	public RestTemplate restTemplate(){
//		return new RestTemplate();
//	}

	@Bean
	public WebClient webClient(){
		return WebClient.builder().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
