package com.uibs.cm.model;

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
public class CustomerAccountDetails
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long accountId;
private String AccountType;
private String accountHolderName;
private String AccountStatus;
private long accountNo;

	
}
