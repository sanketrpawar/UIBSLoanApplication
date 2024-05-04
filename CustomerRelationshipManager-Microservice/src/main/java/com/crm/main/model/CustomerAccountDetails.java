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
public class CustomerAccountDetails
{
@Id
private long accountId;
private String AccountType;
private String accountHolderName;
private String AccountStatus;
private long accountNo;

	
}
