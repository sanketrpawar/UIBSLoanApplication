package com.uibs.crm.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ledger 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ledgerId;
	private String ledgerCreatedDate;
	private double totalLoanAmount;
	private double payableAmountwithInterest;
	private int tenure;
	
	
	
	
}
