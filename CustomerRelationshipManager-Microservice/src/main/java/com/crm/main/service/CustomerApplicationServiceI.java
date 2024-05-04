package com.crm.main.service;

import com.crm.main.model.CustomerApplicationForm;
import com.crm.main.model.CustomerDetails;

public interface CustomerApplicationServiceI  {

	

	public void saveCustomerApplication(CustomerApplicationForm customerApplicationForm);

	

	public void saveCustomerDetails(CustomerDetails customerDetails);



	public CustomerApplicationForm getCustomerApplication(Long applicationNo );

}
