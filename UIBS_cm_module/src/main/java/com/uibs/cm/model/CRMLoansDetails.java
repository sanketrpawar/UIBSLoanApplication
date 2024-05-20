package com.uibs.cm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CRMLoansDetails {

	@Id
	private long applicationNo;
	private String customerName;
	private String mobileNo;
	private String email;
	private String panacardNo;
}
