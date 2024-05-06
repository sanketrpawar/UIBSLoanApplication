package com.crm.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.crm.main.repository.CustomeApplicationRepository;

@Service
public class CustomerApplicationServiceImpl implements CustomerApplicationServiceI {

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
	public CustomerApplicationForm getCustomerApplication(Long applicationNo) {

		List<CustomerApplicationForm> al = applicationRepository.findAll();
		return (CustomerApplicationForm) al;
	}

	@Override
	public void saveCustomerAddress(CustomerAddress address) {
		applicationRepository.save(address);

	}

	@Override
	public void saveEducationDetails(EducationalDetails details) {
		applicationRepository.save(details);

	}

	@Override
	public void saveProfession(Profession profession) {
		applicationRepository.save(profession);

	}

	@Override
	public void saveMortgage(Mortgage mortgage) {

		applicationRepository.save(mortgage);
	}

	@Override
	public void saveCustomerAccountDetails(CustomerAccountDetails customerAccountDetails) {

		applicationRepository.save(customerAccountDetails);
	}

	@Override
	public void savePreviousLaon(PreviousLoan previousLoan) {
		applicationRepository.save(previousLoan);

	}

	@Override
	public void savePropertyDetails(PropertyDetails propertyDetails) {

		applicationRepository.save(propertyDetails);
	}

	@Override
	public void saveAllPersonalDocs(AllPersonalDocs allPersonalDocs) {

		applicationRepository.save(allPersonalDocs);

	}

	@Override
	public void saveSanctionLetter(SanctionLetter letter) {
		applicationRepository.save(letter);

	}

	@Override
	public void saveSanctionLetter(Ledger ledger) {
		applicationRepository.save(ledger);
	}

	@Override
	public void saveSanctionLetter(LoanDisbursement loanDisbursement) {
		applicationRepository.save(loanDisbursement);

	}

}
