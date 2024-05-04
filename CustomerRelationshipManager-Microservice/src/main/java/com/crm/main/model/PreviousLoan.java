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
public class PreviousLoan 
{
	@Id
private  long loanId;
private double previousLoanAmount;
private double paidAmount;
private double remainingAmount;
private int defaulterCount;
private String loanStatus;
private String remark;
@OneToOne(cascade = CascadeType.ALL)
//@OneToOne(cascade = CascadeType.ALL,mappedBy = "PreviousLoan")
private Previousloanbankdetails previousloanbankdetails;


}
