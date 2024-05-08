package com.crm.main.model;

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
public class SanctionLetter 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sanctionId;
	private String sanctionDate;
	private String applicantName;
	private String contactDetails;
	private double loanAmountSanctioned;
	private String interestType;
	private float rateofInterest;
	private int loanTenure;
	private double monthlyemiAmount;
	private String modeofPayment;
	
}
