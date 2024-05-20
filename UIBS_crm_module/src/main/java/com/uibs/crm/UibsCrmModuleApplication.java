package com.uibs.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UibsCrmModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(UibsCrmModuleApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		
		RestTemplate rt = new RestTemplate();
		return rt;
	}
}
