package com.uibs.cibilchecker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {

	private String toMail;
	private String fromEmail;
	private String textMessage;
	private String subject;
	
}
