package com.crm.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Propertyaddress 
{
	

	@Id
private	long propertyAdrId; 
private String propertyAreaName;
private String 	propertyCityName;
private String	propertyDistrict;
private String 	propertyState;
private int 	propertyPinCode;

	
}
