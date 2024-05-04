package com.crm.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.crm.main.model.CustomerAccountDetails;
import com.crm.main.model.CustomerApplicationForm;
import com.crm.main.model.CustomerDetails;
import com.crm.main.service.CustomerApplicationServiceI;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/customerApplicationform")
public class CustomerApplicationController {

	@Autowired
	private CustomerApplicationServiceI customerApplicationServiceI;
	//http://localhost:5000/FormData
	@PostMapping("/FormData")
	public ResponseEntity<String> saveCustomerApplicationForm(@RequestPart("professionsalarySlips") MultipartFile file1,
			@RequestPart("propertyProof") MultipartFile file2, @RequestPart("propertyInsurance") MultipartFile file3,
			@RequestPart("addressProof") MultipartFile file4, @RequestPart("panCard") MultipartFile file5,
			@RequestPart("aadhar") MultipartFile file6, @RequestPart("incomeTaxReturn") MultipartFile file7,
			@RequestPart("photo") MultipartFile file8, @RequestPart("signature") MultipartFile file9,
			@RequestPart("thumb") MultipartFile file10, @RequestPart("bankCheque") MultipartFile file11,
			@RequestPart("bankStatement") MultipartFile file12, @RequestPart("jsonData") String jsonData) {
		try {
			// Convert JSON data to CustomerApplicationForm object
			ObjectMapper objectMapper = new ObjectMapper();
			CustomerApplicationForm customerApplicationForm = objectMapper.readValue(jsonData,
					CustomerApplicationForm.class);

			// Save customer application form
			customerApplicationServiceI.saveCustomerApplication(customerApplicationForm);
			log.info("Customer application form saved successfully.");
			return ResponseEntity.ok("Customer application form saved successfully.");
		} catch (Exception e) {
			log.error("Failed to save customer application form", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to save customer application form.");
		}

	}

	
	
	//http://localhost:5000/CustomerDetails
	@PostMapping("/CustomerDetails")
	public ResponseEntity<String> createCustomerDetails(@RequestBody CustomerDetails customerDetails) {
		try {
			// Save customer details to the database
			customerApplicationServiceI.saveCustomerDetails(customerDetails);
			return ResponseEntity.status(HttpStatus.CREATED).body("Customer details saved successfully!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to save customer details: " + e.getMessage());
		}
	}

}
