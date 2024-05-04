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
public class GuarantorDetails 
{
	@Id
	private int guarantorId;
	private String guarantorName;
	private String guarantorDOB;
	private String guarantorRelationshipwithCustomer;
	private long guarantorMobileNo;
	private long guarantorAdharcardNo;
	private String guarantorCityName;
	private String guarantorJobDetails;
	private String guarantorAreaName;

}
