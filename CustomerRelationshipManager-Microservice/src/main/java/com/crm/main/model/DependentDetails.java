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
public class DependentDetails 
{
	@Id
	private long dependentId;
	
	private String fatherName;
	
	private String motherName;
	
	private int noofChild;
	
	private String martialStatus;
	
	private int noofFamilyMember;
	
	private Double familyIncome;
	
	private String spouseName;
	
	private int dependentMember;
	
}
