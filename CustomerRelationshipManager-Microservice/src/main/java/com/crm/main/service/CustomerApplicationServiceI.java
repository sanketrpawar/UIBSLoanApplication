package com.crm.main.service;

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

public interface CustomerApplicationServiceI {

	public void saveCustomerApplication(CustomerApplicationForm customerApplicationForm);

	public void saveCustomerDetails(CustomerDetails customerDetails);

	public CustomerApplicationForm getCustomerApplication(Long applicationNo);

	public void saveCustomerAddress(CustomerAddress address);

	public void saveEducationDetails(EducationalDetails details);

	public void saveProfession(Profession profession);

	public void saveMortgage(Mortgage mortgage);

	public void saveCustomerAccountDetails(CustomerAccountDetails customerAccountDetails);

	public void savePreviousLaon(PreviousLoan previousLoan);

	public void savePropertyDetails(PropertyDetails propertyDetails);

	public void saveAllPersonalDocs(AllPersonalDocs allPersonalDocs);

	public void saveSanctionLetter(SanctionLetter letter);

	public void saveSanctionLetter(Ledger ledger);

	public void saveSanctionLetter(LoanDisbursement loanDisbursement);
}
