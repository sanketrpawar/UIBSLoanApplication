	package com.uibs.cm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int documentId;
	@Lob
	@Column(length = 200000)
	private byte[] addressProof;
	@Lob
	@Column(length = 200000)
	private byte[] panCard;
	@Lob
	@Column(length = 200000)
	private byte[] aadharCard;
	@Lob
	@Column(length = 200000)
	private byte[] incomeTaxReturn;
	@Lob
	@Column(length = 200000)
	private byte[] photo;
	@Lob
	@Column(length = 200000)
	private byte[] signature;
	@Lob
	@Column(length = 200000)
	private byte[] thumb;
	@Lob
	@Column(length = 200000)
	private byte[] bankCheque;
	@Lob
	@Column(length = 200000)
	private byte[] bankStatement;
	
	private String personalData;
	
	
}
