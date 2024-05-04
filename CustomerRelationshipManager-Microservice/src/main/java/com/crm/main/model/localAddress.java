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
public class localAddress 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int localId;
	private String areaName;
	private String cityName;
	private String district;
	private String state;
	private double pinCode;
	private String houseNo;
	private String streetName;
	
	
	
}
