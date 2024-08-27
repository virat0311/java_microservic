package com.pandey.crudOpsResFullServ;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "spring boot rest Api documentation",
				description="rest api deoc",
				version = "v1.0",
				contact = @Contact(
						name="pandey",
						email="jevevanorhan@gmail.com",
						url="https://www.jafasf.ne/roha"
				),
				license = @License(
						name="rohan",
						url="http://www/spidermonkey"
				)

		),externalDocs=@ExternalDocumentation(
		description = "spring doc to create try",
		url="https://800808/rohan"

     )
)
public class CrudOpsResFullServApplication {
	//after creating mapper class and methods we than moved to mapper third party library to map dto and entity
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(CrudOpsResFullServApplication.class, args);
	}

}
