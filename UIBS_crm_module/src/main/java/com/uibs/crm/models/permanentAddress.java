package com.uibs.crm.models;

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
public class permanentAddress 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int permanentId;
	private String areaName;
	private String cityName;
	private String district;
	private String state;
	private double  pinCode;
	
	private String houseNo;
	private String streetName;
	

}
