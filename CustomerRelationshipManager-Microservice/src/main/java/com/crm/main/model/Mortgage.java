package com.crm.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Mortgage
{
	@Id
 private long mortgageId;
 private double propertyValue;
 private byte[] profertyProof;
 private byte[] propertyInsurance;
 private String propertyType;
 private double loanonProperty;
 
 
 
 
}
