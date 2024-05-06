package com.crm.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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

@Repository
public interface CustomeApplicationRepository extends JpaRepository<CustomerApplicationForm, Integer> {

	public void save(CustomerDetails customerDetails);

	public void save(CustomerAddress address);

	public void save(EducationalDetails details);

	public void save(Profession profession);

	public void save(Mortgage mortgage);

	public void save(CustomerAccountDetails customerAccountDetails);

	public void save(PreviousLoan previousLoan);

	public void save(PropertyDetails propertyDetails);

	public void save(AllPersonalDocs allPersonalDocs);

	public void save(SanctionLetter letter);

	public void save(Ledger ledger);

	public void save(LoanDisbursement loanDisbursement);

}
