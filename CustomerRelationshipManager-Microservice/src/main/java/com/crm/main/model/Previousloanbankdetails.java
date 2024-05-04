package com.crm.main.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Previousloanbankdetails 
{

	@Id
	private long branchId;
	private String branchName;
	private String ifscCode;
	private String micrCode;
	private long contactNo;
	private String emailId;
	private String status;
	@OneToOne(cascade = CascadeType.ALL)
//	@OneToOne(cascade = CascadeType.ALL, mappedBy = "Previousloanbankdetails")
	private Previousbankaddress previousbankaddress;
	
	
}
