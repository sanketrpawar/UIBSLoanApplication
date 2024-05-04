package com.crm.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient @SpringBootApplication
public class CustomerRelationshipManagerMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerRelationshipManagerMicroserviceApplication.class, args);
		System.out.println("this  is CRM Model ");
		
	}

}
