package com.crm.main.model;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CustomerApplicationForm 
{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int applicationNo ;

@OneToOne(cascade = CascadeType.ALL)
private CustomerDetails customerDetails;

@OneToOne(cascade = CascadeType.ALL)
private DependentDetails dependentDetails;

@OneToOne(cascade = CascadeType.ALL)

private CustomerAddress customerAddress;

@OneToOne(cascade = CascadeType.ALL)
private EducationalDetails educationalDetails;

@OneToOne(cascade = CascadeType.ALL)
private Profession profession;

@OneToOne(cascade = CascadeType.ALL)
private Mortgage mortgage;

@OneToOne(cascade = CascadeType.ALL)
private CustomerAccountDetails customeraccountDetails;

@OneToOne(cascade = CascadeType.ALL)
private PreviousLoan previousLoan;

@OneToOne(cascade = CascadeType.ALL)
private GuarantorDetails guarantorDetails;

@OneToOne(cascade = CascadeType.ALL)
private PropertyDetails propertyDetails;

@OneToOne(cascade = CascadeType.ALL)
private AllPersonalDocs allpersonalDocs;

@OneToOne(cascade = CascadeType.ALL)
private SanctionLetter sanctionLetter;

@OneToOne(cascade = CascadeType.ALL)
private Ledger ledger;

@OneToOne(cascade = CascadeType.ALL)
private LoanDisbursement loanDisbursement;










}
