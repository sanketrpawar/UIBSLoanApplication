package com.uibs.bank.registration_module.service;

import com.uibs.bank.registration_module.model.Customer;
import com.uibs.bank.registration_module.model.Email;

import jakarta.validation.Valid;

public interface CustomerRegistrationService {

	public Customer saveCustomer(Customer customer);

	public void sendEnquiryMail(Customer customer, Email email);

	public Customer loginCustomer(String username, String password);

	public Customer getCustomer(int id);


}
