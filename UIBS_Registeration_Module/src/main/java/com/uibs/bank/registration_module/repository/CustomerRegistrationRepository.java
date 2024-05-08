package com.uibs.bank.registration_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uibs.bank.registration_module.model.Customer;

public interface CustomerRegistrationRepository extends JpaRepository<Customer, Integer>{

	public Customer findByUsernameAndPassword(String username, String password);
	
}
