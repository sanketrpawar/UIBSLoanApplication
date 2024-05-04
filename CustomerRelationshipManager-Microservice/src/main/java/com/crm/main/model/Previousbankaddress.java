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
public class Previousbankaddress 
{
	@Id
private long bankId;
private String bankArea;
private String bankCity;
private String bankDistrict;
private String bankState;
private int pinCode;

}
