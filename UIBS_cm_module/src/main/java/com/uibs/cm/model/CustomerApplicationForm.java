package com.uibs.cm.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CustomerApplicationForm {
	@Id
	private int applicationNo;

	@OneToOne(cascade = CascadeType.ALL)
	private CustomerDetails customerDetails;

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
	private PropertyDetails propertyDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private AllPersonalDocs allpersonalDocs;

	@OneToOne(cascade = CascadeType.ALL)
	private SanctionLetter sanctionLetter;


}
