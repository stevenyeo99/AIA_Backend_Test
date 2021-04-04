package com.hubbers.aia.steven.backend.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.HypermediaMappingInformation;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class AiaBackendTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiaBackendTestApplication.class, args);
	}
	
	@Bean
	public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder,
	                                 HypermediaMappingInformation mappingInformation) {
	    ObjectMapper objectMapper = builder.build();
	    mappingInformation.configureObjectMapper(objectMapper);
	    return objectMapper;
	}
}
