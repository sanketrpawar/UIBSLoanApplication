package com.crm.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor
@Entity 
public class LoanDisbursement {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long aggrementId;
private long loanNumber;
private String aggrementDate;
private String amountPayType;
private double totalAmount;
private String bankName;
private long accountNumber;
private String ifscCode;
private String accountType;
private double transferAmount;
private String paymentStatus;
private String amountPaidDate;


}
