package com.uibs.oe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CRMLoansDetails {
	
	@Id
	private long applicationNo;
	private String customerName;
	private long mobileNo;
	private String email;
	private String pancardNo;

}
