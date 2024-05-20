package com.uibs.crm.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {

	private String toMail;
	private String fromEmail;
	private String textMessage;
	private String subject;
}
