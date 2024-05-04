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

public class AllPersonalDocs
{
	@Id
	private int documentId;
	private byte[] addressProof;
	private byte[] panCard;
	private byte[] aadharCard;
	private byte[] incomeTaxReturn;
	private byte[] photo;
	private byte[] signature;
	private byte[] thumb;
	private byte[] bankCheque;
	private byte[] bankStatement;
	
	
}
