package com.hb.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring boot Rest API Documentation for Department Service",
				description = "Spring boot Rest API Documentation for Department Service",
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
				description = "Spring boot Rest API Documentation for Department Service",
				url = "https://github.com/h4rishabh/microservices-brushup-2023/tree/master/springboot-microservices/department-service"
		)
)
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
