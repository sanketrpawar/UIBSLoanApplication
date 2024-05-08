package com.uibs.bank.registration_module.model;

//import com.UIBS.Enquiry_Module.model.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {

	private String toMail;
	private String fromMail;
	private String textMessage;
	private String subject;
}
