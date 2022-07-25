package com.attornatus.backend.documentation;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class Documentation {

	
	@Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("Documentação da Api")
	              .description("Documentação da api desenvolvida para teste técnico, "
	              		+ "da attornatus.")
	              .version("v0.0.1")
	              .license(new License().name("Apache 2.0").url("http://springdoc.org")))
	              .externalDocs(new ExternalDocumentation()
	              .description("Desafio técnico para desenvolver uma api para gerenciamento de pessoa ")
	              .url("http://localhost:8080/swagger-ui/index.html#/"));
	  }
}
