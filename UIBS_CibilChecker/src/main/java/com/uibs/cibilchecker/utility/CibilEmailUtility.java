package com.uibs.cibilchecker.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.uibs.cibilchecker.model.Email;
import com.uibs.cibilchecker.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CibilEmailUtility {

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

	public void sendSimpleMail(User user, Email email, int f) {

		log.info("executing sendSimpleMail method of EnquiryEmailUtility. Setting email subject and email text message");
		
		email.setSubject("OTP for cibil rating");
		email.setTextMessage("Dear " + user.getFullName() + ",\n\n"
                + "Your OTP for checking cibil score is "+ f +". Please enter this OTP to check your score.");
		SimpleMailMessage m = new SimpleMailMessage();
		m.setTo(user.getEmail());
		m.setFrom(email.getFromEmail());
		m.setSubject(email.getSubject());
		m.setText(email.getTextMessage());

		sender.send(m);
		
		log.info("Successfully executed sendSimpleMail method of EnquiryEmailUtility. Email sent to the user.");
		System.out.println("MAIL SENT");
		
	}
}
