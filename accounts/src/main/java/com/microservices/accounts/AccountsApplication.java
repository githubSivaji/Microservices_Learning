package com.microservices.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication()
@EnableJpaAuditing(auditorAwareRef="auditAwareImpl")
@OpenAPIDefinition(
	    info = @Info(
	        title = "Accounts microservice REST API Documentation",
	        description = "Bank Accounts microservices REST API Documentation",
	        version = "V1",
	        contact = @Contact(
	            name = "Sivaji",
	            email = "siva@gmail.com", 
	            url = "https://sivaji.com"
	        ),
	        license = @License(
	            name = "Apache 2.0",
	            url = "https://www.apache.org/licenses/LICENSE-2.0"
	        )
	    ),
	    externalDocs = @ExternalDocumentation(
	        description = "Accounts Service Wiki",
	        url = "https://sivaji.com/docs"
	    )
	)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
