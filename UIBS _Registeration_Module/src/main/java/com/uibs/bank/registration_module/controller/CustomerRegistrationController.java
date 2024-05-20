package com.uibs.bank.registration_module.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.uibs.bank.registration_module.model.Customer;
import com.uibs.bank.registration_module.model.Email;
import com.uibs.bank.registration_module.model.SuccessMsg;
import com.uibs.bank.registration_module.service.CustomerRegistrationService;
import com.uibs.bank.registration_module.utility.CustomerRegistrationUtility;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/uibs")
@CrossOrigin
public class CustomerRegistrationController {

	@Autowired
	CustomerRegistrationService customerRegistrationService;

	@Autowired
	CustomerRegistrationUtility customerRegistrationUtility;

	@Value("${spring.mail.username}")
	private String fromMail;

	@PostMapping("/register_customer")
	public ResponseEntity<String> registerCustomer(@Valid @RequestBody Customer customer, Email email) {

		try {
			email.setFromMail(fromMail);

			System.out.println(email.getFromMail());
			Customer saveCustomer = customerRegistrationService.saveCustomer(customer);
			customerRegistrationService.sendEnquiryMail(customer, email);
			System.out.println("aaa");
			return new ResponseEntity<String>("Registered successfully " + saveCustomer, HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<String>("Mail could not be sent", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/login_customer")
	public ResponseEntity<Customer> loginCustomer(@RequestParam String username, @RequestParam String password) {

		Customer loginCustomer = customerRegistrationService.loginCustomer(username, password);
		
		SuccessMsg msg = new SuccessMsg();
		
		msg.setId(loginCustomer.getId());
		msg.setMsg("Logged in");

		if (loginCustomer.getUsername().equals(username) && loginCustomer.getPassword().equals(password)) {
			return new ResponseEntity<Customer>(loginCustomer, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Customer>(loginCustomer, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/get_login_user/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int id){
		
		Customer customer = customerRegistrationService.getCustomer(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
}
