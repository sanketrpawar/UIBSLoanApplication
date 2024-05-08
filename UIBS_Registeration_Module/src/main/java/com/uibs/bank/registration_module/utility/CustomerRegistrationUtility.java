package com.uibs.bank.registration_module.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.uibs.bank.registration_module.model.Customer;
import com.uibs.bank.registration_module.model.Email;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomerRegistrationUtility {

	@Autowired
    private JavaMailSender sender;
	
	public void sendSimpleMail(Customer customer, Email email) {
		
		email.setSubject("Enquiry Submitted Successfull");
		email.setTextMessage("Dear " + customer.getFirstName()+" "+customer.getMiddleName()+" "+customer.getLastName() + ",\n\n"
                + "Thank you for your inquiry. If you're still interested in a loan, please apply at your earliest convenience.\n\n"
                + "Best regards,\nYour Lending Team");
		SimpleMailMessage m = new SimpleMailMessage();
		m.setTo(customer.getEmail());
		m.setFrom(email.getFromMail());
		m.setSubject(email.getSubject());
		m.setText(email.getTextMessage());

		sender.send(m);
		System.out.println("MAIL SENT");
	}

}
