package com.uibs.oe.model;

import java.time.LocalDateTime;

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
