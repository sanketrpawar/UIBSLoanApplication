package com.uibs.cm.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SanctionLetter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sanctionId;
	
	private String applicantName;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "submission_date", nullable = false, updatable = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-dd-MM")
	private Date sanctionDate;
	
	private long loanAmountSanctioned;
	
	private float rateOfInterest;
	
	private int loanTenure;
	
	private Double monthlyEmiAmount;
	
	private String modeOfPayment;
	
	private String email;
	
	@Lob
	@Column(length = 2000000)
	private byte[] letter;
	
	@PrePersist
    protected void onCreate() {
        this.sanctionDate = new Date(); // Set the date to the current date
    }
}
