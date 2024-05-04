package com.crm.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.main.model.CustomerApplicationForm;
import com.crm.main.model.CustomerDetails;
import com.crm.main.repository.CustomeApplicationRepository;


@Service
public class CustomerApplicationServiceImpl implements CustomerApplicationServiceI{

	@Autowired
	CustomeApplicationRepository applicationRepository;
	
	@Override
	public void saveCustomerApplication(CustomerApplicationForm customerApplicationForm) {
		applicationRepository.save(customerApplicationForm);
		
	}
	@Override
	public void saveCustomerDetails(CustomerDetails customerDetails) {
		applicationRepository.save(customerDetails);
		
	}
	@Override
	public CustomerApplicationForm getCustomerApplication(Long applicationNo ) {
		
		List<CustomerApplicationForm > al =applicationRepository.findAll();
		return (CustomerApplicationForm) al;
	}

}
