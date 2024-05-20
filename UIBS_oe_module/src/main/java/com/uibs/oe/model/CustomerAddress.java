package com.uibs.oe.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	
	@Entity
	public class CustomerAddress 
	{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long customerAddressId;
		private String areaName;
		private String cityName;
		private String district;
		private String state;
		private String pinCode;
		private String houseNo;
		private String streetName;
		
//		@OneToOne(cascade = CascadeType.ALL)
//		@JoinColumn(name = "permanent_address_id")
//		private permanentAddress permanentaddress;
//		@OneToOne(cascade = CascadeType.ALL ,mappedBy = "CustomerAddress")	
//	
//		@OneToOne(cascade = CascadeType.ALL)
//		@JoinColumn(name = "local_address_id")
//		private localAddress localaddress;	
//		@OneToOne(cascade = CascadeType.ALL,mappedBy = "CustomerAddress"
	}
