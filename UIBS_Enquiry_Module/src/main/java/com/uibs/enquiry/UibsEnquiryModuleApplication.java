package com.uibs.enquiry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UibsEnquiryModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(UibsEnquiryModuleApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		
		RestTemplate rt = new RestTemplate();
		return rt;
		
	}

}
