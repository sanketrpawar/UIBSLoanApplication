package com.crm.main.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.crm.main.model.AllPersonalDocs;
import com.crm.main.model.CustomerAccountDetails;
import com.crm.main.model.CustomerAddress;
import com.crm.main.model.CustomerApplicationForm;
import com.crm.main.model.CustomerDetails;
import com.crm.main.model.EducationalDetails;
import com.crm.main.model.Ledger;
import com.crm.main.model.LoanDisbursement;
import com.crm.main.model.Mortgage;
import com.crm.main.model.PreviousLoan;
import com.crm.main.model.Profession;
import com.crm.main.model.PropertyDetails;
import com.crm.main.model.SanctionLetter;
import com.crm.main.service.CustomerApplicationServiceI;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin("http://localhost:4200")
@RestController
@Slf4j
//@RequestMapping("/customerApplicationform")
public class CustomerApplicationController {

	@Autowired
	private CustomerApplicationServiceI customerApplicationServiceI;

	// Declared for Deserialize (JSON to Java Object)
	static ObjectMapper objectMapper = new ObjectMapper();

//API for Handling Customer Details  
// http://localhost:5000/customerDetails
	@PostMapping("/customerDetails")
	public ResponseEntity<String> setcustomerDetails(@RequestBody CustomerDetails customerDetails) {
		log.info("Received request to save customer details: {}", customerDetails);
		customerApplicationServiceI.saveCustomerDetails(customerDetails);
		log.info("Customer details saved successfully: {}", customerDetails);
		return new ResponseEntity<String>("Saved Customer Details ", HttpStatus.OK);

	}

	// API for Handling Customer Address
	// http://localhost:5000/customerAddress
	@PostMapping("/customerAddress")
	public ResponseEntity<String> setcustomerAddress(@RequestBody CustomerAddress address) {
		customerApplicationServiceI.saveCustomerAddress(address);
		return new ResponseEntity<String>("Saved Customer Address ", HttpStatus.OK);
	}

	// API for Handling Customer Education Details
	// http://localhost:5000/customerEducationDetails
	@PostMapping("/customerEducationDetails")
	public ResponseEntity<String> saveEducationDetails(@RequestBody EducationalDetails details) {
		customerApplicationServiceI.saveEducationDetails(details);
		return new ResponseEntity<String>("Saved Education Details ", HttpStatus.OK);

	}

	// API for Handling Customer Profession
	// http://localhost:5000/customerProfession
	@PostMapping("/customerProfession")
	public ResponseEntity<String> setProfession(@RequestPart("professionsalarySlips") MultipartFile file1,
			@RequestPart("Professiondata") String json1) throws IOException {
//		Profession profession = new Profession();
//		profession.setProfessionsalartSlips(file1.getBytes());

		// Deserialize
		Profession p = objectMapper.readValue(json1, Profession.class);
		p.setProfessionsalartSlips(file1.getBytes());
		// savetoDatabase
		customerApplicationServiceI.saveProfession(p);
		return new ResponseEntity<String>("Saved Profession", HttpStatus.OK);
	}

	// API for Handling Customer Mortgage
	// http://localhost:5000/customerMortgage
	@PostMapping("/customerMortgage")
	public ResponseEntity<String> setMortgage(@RequestPart("propertyProof") MultipartFile file2,
			@RequestPart("propertyInsurance") MultipartFile file3, @RequestPart("Mortgagedata") String json2)
			throws IOException {

//		Mortgage mortgage = new Mortgage();
//		mortgage.setProfertyProof(file2.getBytes());
//		mortgage.setPropertyInsurance(file3.getBytes());

		// Deserialize
		Mortgage m = objectMapper.readValue(json2, Mortgage.class);
		m.setProfertyProof(file2.getBytes());
		m.setPropertyInsurance(file3.getBytes());
		// savetoDatabase
		customerApplicationServiceI.saveMortgage(m);

		return new ResponseEntity<String>("Saved Mortgage", HttpStatus.OK);

	}

	// API for Handling Customer Account Details
	// http://localhost:5000/CustomerAccountDetails
	@PostMapping("/CustomerAccountDetails")
	public ResponseEntity<String> setCustomerAccountDetails(
			@RequestBody CustomerAccountDetails customerAccountDetails) {

		customerApplicationServiceI.saveCustomerAccountDetails(customerAccountDetails);
		return new ResponseEntity<String>("Saved Customer Account Details  ", HttpStatus.OK);

	}

	// API for Handling Customer Previous Loan
	// http://localhost:5000/PreviousLoan
	@PostMapping("/PreviousLoan")
	public ResponseEntity<String> setPreviousLoan(@RequestBody PreviousLoan previousLoan) {
		customerApplicationServiceI.savePreviousLaon(previousLoan);
		return new ResponseEntity<String>("Saved Customer Presvious Loan Details   ", HttpStatus.OK);

	}

	// API for Handling Customer Property Details
	// http://localhost:5000/PropertyDetails
	@PostMapping("/PropertyDetails")
	public ResponseEntity<String> setPropertyDetails(@RequestBody PropertyDetails propertyDetails) {
		customerApplicationServiceI.savePropertyDetails(propertyDetails);
		return new ResponseEntity<String>("Saved Customer Presvious Loan Details   ", HttpStatus.OK);

	}

	// API for Handling All Personal Documents
	// http://localhost:5000/AllPersonalDocs
	@PostMapping("/AllPersonalDocs")
	public ResponseEntity<String> setAllPersonalDocs(@RequestPart("addressProof") MultipartFile file4,
			@RequestPart("panCard") MultipartFile file5, @RequestPart("aadhar") MultipartFile file6,
			@RequestPart("incomeTaxReturn") MultipartFile file7, @RequestPart("photo") MultipartFile file8,
			@RequestPart("signature") MultipartFile file9, @RequestPart("thumb") MultipartFile file10,
			@RequestPart("bankCheque") MultipartFile file11, @RequestPart("bankStatement") MultipartFile file12,
			@RequestPart("personalData") String json3) throws IOException {

//		AllPersonalDocs allPersonalDocs = new AllPersonalDocs();
		

		// Deserialize
		AllPersonalDocs allPersonalDocs = objectMapper.readValue(json3, AllPersonalDocs.class);
		allPersonalDocs.setAddressProof(file4.getBytes());
		allPersonalDocs.setPanCard(file5.getBytes());
		allPersonalDocs.setAadharCard(file6.getBytes());
		allPersonalDocs.setIncomeTaxReturn(file7.getBytes());
		allPersonalDocs.setPhoto(file8.getBytes());
		allPersonalDocs.setSignature(file9.getBytes());
		allPersonalDocs.setThumb(file10.getBytes());
		allPersonalDocs.setBankCheque(file11.getBytes());
		allPersonalDocs.setBankStatement(file12.getBytes());

		// savetoDatabase
		customerApplicationServiceI.saveAllPersonalDocs(allPersonalDocs);
		return new ResponseEntity<String>("Saved Customer All Personal Documents ", HttpStatus.OK);

	}

	// API for Handling All Sanction Letter
	// http://localhost:5000/SanctionLetter
	@PostMapping("/SanctionLetter")
	public ResponseEntity<String> setSanctionLetter(@RequestBody SanctionLetter letter) {
		customerApplicationServiceI.saveSanctionLetter(letter);

		return new ResponseEntity<String>("Saved Sanctioned Letter ", HttpStatus.OK);
	}

	// API for Handling Ledger Details
	// http://localhost:5000/Ledger
	@PostMapping("/Ledger")
	public ResponseEntity<String> setLedgerDetails(@RequestBody Ledger ledger) {
		customerApplicationServiceI.saveSanctionLetter(ledger);

		return new ResponseEntity<String>("Saved Ledger Details ", HttpStatus.OK);
	}

	// API for Handling Loan Disbursement
	// http://localhost:5000/LoanDisbursement
	@PostMapping("/LoanDisbursement")
	public ResponseEntity<String> setSLoanDisbursement(@RequestBody LoanDisbursement loanDisbursement) {
		customerApplicationServiceI.saveSanctionLetter(loanDisbursement);

		return new ResponseEntity<String>("Saved Ledger Details ", HttpStatus.OK);
	}

	// Retrieve data through id
	@GetMapping("/FormData/{formId}")
	public ResponseEntity<CustomerApplicationForm> getCustomerApplicationForm(@PathVariable Long applicationNo) {
		try {
			// Retrieve customer application form from the service layer based on formId
			CustomerApplicationForm customerApplicationForm = customerApplicationServiceI
					.getCustomerApplication(applicationNo);
			if (customerApplicationForm != null) {
				return ResponseEntity.ok(customerApplicationForm);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			log.error("Failed to fetch customer application form", e);
			return (ResponseEntity<CustomerApplicationForm>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}

//	@PostMapping("/FormData")
//	public ResponseEntity<String> saveCustomerApplicationForm(@RequestPart("professionsalarySlips") MultipartFile file1,
//			@RequestPart("propertyProof") MultipartFile file2, @RequestPart("propertyInsurance") MultipartFile file3,
//			@RequestPart("addressProof") MultipartFile file4, @RequestPart("panCard") MultipartFile file5,
//			@RequestPart("aadhar") MultipartFile file6, @RequestPart("incomeTaxReturn") MultipartFile file7,
//			@RequestPart("photo") MultipartFile file8, @RequestPart("signature") MultipartFile file9,
//			@RequestPart("thumb") MultipartFile file10, @RequestPart("bankCheque") MultipartFile file11,
//			@RequestPart("bankStatement") MultipartFile file12) {
//		
//		AllPersonalDocs allPersonalDocs=new AllPersonalDocs();
//		
//		allPersonalDocs.setBankStatement(file1.getBytes());
//		
//		
//
//		try {
//			// Convert JSON data to CustomerApplicationForm object
//			ObjectMapper objectMapper = new ObjectMapper();
////			CustomerApplicationForm customerApplicationForm = objectMapper.readValue(jsonData,
////					CustomerApplicationForm.class);
//
//			// Save customer application form
//			customerApplicationServiceI.saveCustomerApplication(customerApplicationForm);
//			log.info("Customer application form saved successfully.");
//			return ResponseEntity.ok("Customer application form saved successfully.");
//		} catch (Exception e) {
//			log.error("Failed to save customer application form", e);
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//					.body("Failed to save customer application form.");
//		}
//
//	}
//
//	
//	
//	//http://localhost:5000/CustomerDetails
//	@PostMapping("/CustomerDetails")
//	public ResponseEntity<String> createCustomerDetails(@RequestBody CustomerDetails customerDetails) {
//		try {
//			// Save customer details to the database
//			customerApplicationServiceI.saveCustomerDetails(customerDetails);
//			return ResponseEntity.status(HttpStatus.CREATED).body("Customer details saved successfully!");
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//					.body("Failed to save customer details: " + e.getMessage());
//		}
//	}
//	
//	
//	
//	
//	
//	    
//	
//	
