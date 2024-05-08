package com.crm.main.model;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class CustomerDetails 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	
	private String customerName;
	
	private long mobileNo;
	
	private String emailID;
	
	private long adharNo;
	
	private String pancardNo;
	
	private String gender;
	
	private String customerDOB;
	
	private int customerAge;
	
	private String loanType;
	
	private String maritalStatus;
	
	private String statusCode;
	
	private double totalLoanRequired;
	
	private int cibilScore;
	
	
}
