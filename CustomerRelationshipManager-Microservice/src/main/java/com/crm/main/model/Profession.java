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
public class Profession 
{
	@Id
private long professionId;
private String professionType;
private double professionSalary;
private String professionSalaryType;
private String professionWorkingPeriod;
private byte[] professionsalartSlips;



}
