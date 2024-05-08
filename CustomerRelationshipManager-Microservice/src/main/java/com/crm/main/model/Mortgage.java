package com.crm.main.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long mortgageId;
 private double propertyValue;
 @Lob
 @Column(length = 200000)
 private byte[] profertyProof;
 
 @Lob
 @Column(length = 200000)
 private byte[] propertyInsurance;
 private String propertyType;
 private double loanonProperty;
 
 
 
 
}
