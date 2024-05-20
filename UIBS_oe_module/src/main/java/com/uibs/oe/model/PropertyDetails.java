package com.uibs.oe.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PropertyDetails
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long propertyId;
	private  String propertyType;
	private String  propertyArea;
	private String  constructionArea;	
	private double  propertyPrice;
	private double  constructionPrice;
//	@OneToOne(cascade = CascadeType.ALL)
//	@OneToOne(cascade = CascadeType.ALL,mappedBy = "PropertyDetails")
	private String propertyadress;
	

}
