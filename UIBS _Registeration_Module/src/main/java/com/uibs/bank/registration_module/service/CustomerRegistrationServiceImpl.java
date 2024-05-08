package com.uibs.bank.registration_module.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uibs.bank.registration_module.exception.LoginCredentialsNotValidException;
import com.uibs.bank.registration_module.exception.RegistrationUnsuccessfulException;
import com.uibs.bank.registration_module.model.Customer;
import com.uibs.bank.registration_module.model.Email;
import com.uibs.bank.registration_module.repository.CustomerRegistrationRepository;
import com.uibs.bank.registration_module.utility.CustomerRegistrationUtility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerRegistrationServiceImpl implements CustomerRegistrationService {

	@Autowired
	CustomerRegistrationRepository customerRegistrationRepository;

	@Autowired
	CustomerRegistrationUtility customerRegistrationUtility;

	@Override
	public Customer saveCustomer(Customer customer) {

		List<String> al = new ArrayList<String>();
		List<Customer> customerList = customerRegistrationRepository.findAll();

		for (Customer c : customerList) {
			al.add(c.getMobileNo());
		}

		if (al.contains(customer.getMobileNo())) {
			log.info("Exception raised. Customer with mob no. " + customer.getMobileNo() + " already exists!!!");
			throw new RegistrationUnsuccessfulException("Registration was not done successfully");
		}

		else {
			Customer save = customerRegistrationRepository.save(customer);
			return save;
		}

	}

	@Override
	public void sendEnquiryMail(Customer customer, Email email) {

		customerRegistrationUtility.sendSimpleMail(customer, email);
	}

	@Override
	public Customer loginCustomer(String username, String password) {

		List<Customer> customerList = customerRegistrationRepository.findAll();

		Customer findByUsernameAndPassword = customerRegistrationRepository.findByUsernameAndPassword(username, password);

//		List<String> u = new ArrayList<>();
//		List<String> p = new ArrayList<>();
//		
//		for(Customer c : customerList) {
//			u.add(c.getUsername());
//			p.add(c.getPassword());
//			
//			if(u.contains(username) && p.contains(password)){
//				return c;
//			}
//		}

		if (findByUsernameAndPassword.getUsername().equals(username)
				&& findByUsernameAndPassword.getPassword().equals(password)) {
			return findByUsernameAndPassword;
		} else {
			throw new LoginCredentialsNotValidException("Login Credentials Not Valid");
		}
	}
}
