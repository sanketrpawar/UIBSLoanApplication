package com.crm.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EducationalDetails 
{
	@Id
	private long educationId;
	private String educationalSpecialization;
	private int passingYear;
	
	private String qualification;
	
}