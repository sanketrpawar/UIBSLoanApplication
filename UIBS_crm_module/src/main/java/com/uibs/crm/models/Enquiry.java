package com.uibs.crm.models;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enquiry {

	@Id
	private long id;
	
	private String enquiryName;
	
	private int age;
	
	private String email;
	
	private long mobileNo;
	
	private String pancardNo;
	
	private String remark;
	
    private Date submissionDate;

    private boolean loanApplied;
	
//    @OneToOne(cascade = CascadeType.ALL)
//	private CibilScore cibilScore;
    
}
