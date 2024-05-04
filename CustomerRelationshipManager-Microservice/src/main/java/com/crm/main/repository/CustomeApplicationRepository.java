package com.crm.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.main.model.CustomerApplicationForm;
import com.crm.main.model.CustomerDetails;

@Repository
public interface CustomeApplicationRepository  extends JpaRepository<CustomerApplicationForm, Integer>
{

	

	public void save(CustomerDetails customerDetails);

}
