package com.fintellix.paginationsorting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PaginationSortingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaginationSortingApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer(){
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // enabling to everything
				.allowedMethods("*") // allow all methods
				.allowedOrigins("http://localhost:3000"); //Origin website
			}
		};
	}
}
