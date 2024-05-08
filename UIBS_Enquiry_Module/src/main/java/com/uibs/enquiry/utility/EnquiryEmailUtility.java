package com.uibs.enquiry.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.uibs.enquiry.model.Email;
import com.uibs.enquiry.model.Enquiry;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EnquiryEmailUtility {

	@Autowired
	JavaMailSender sender;

//	public void sendSimpleMail(String to, String from, String subject, String text) {
//
//		SimpleMailMessage m = new SimpleMailMessage();
//		m.setTo(to);
//		m.setFrom(from);
//		m.setSubject(subject);
//		m.setText(text);
//
//		sender.send(m);
//		System.out.println("MAIL SENT");
//	}

	public void sendSimpleMail(Enquiry enquiry, Email email) {

		log.info("executing sendSimpleMail method of EnquiryEmailUtility. Setting email subject and email text message");
		
		email.setSubject("Enquiry Submitted Successfull");
		email.setTextMessage("Dear " + enquiry.getEnquiryName() + ",\n\n"
                + "Thank you for your inquiry. If you're still interested in a loan, please apply at your earliest convenience.\n\n"
                + "Best regards,\nYour Lending Team");
		SimpleMailMessage m = new SimpleMailMessage();
		m.setTo(enquiry.getEmail());
		m.setFrom(email.getFromEmail());
		m.setSubject(email.getSubject());
		m.setText(email.getTextMessage());

		sender.send(m);
		
		log.info("Successfully executed sendSimpleMail method of EnquiryEmailUtility. Email sent to the user.");
		System.out.println("MAIL SENT");
		
	}
}
