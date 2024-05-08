package com.uibs.oe.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Enquiry {

	@Id
	private long id;

	private String enquiryName;

	private int age;

	private String email;
	
	private long mobileNo;
	
	private String pancardNo;
	
	private String remark;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date submissionDate;

    private boolean loanApplied;
	
    @OneToOne(cascade = CascadeType.ALL)
	private CibilScore cibilScore;
    
}
