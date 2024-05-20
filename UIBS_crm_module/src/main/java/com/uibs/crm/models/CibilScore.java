package com.uibs.crm.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CibilScore {

	@Id
	private long id;
	
	private int cibilScore;
	
	private String cibilScoreDate;
	
	private String status;
}

