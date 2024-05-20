package com.uibs.cm.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.uibs.cm.model.Email;
import com.uibs.cm.model.SanctionLetter;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EmailSenderUtility {

	@Autowired
	JavaMailSender sender;
	
	public void sendSanctionLetterWithAttachment(SanctionLetter sanction, Email e, MultipartFile f) throws MessagingException {

		MimeMessage message = sender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			e.setSubject("Sanction Letter from UIBS");
			e.setTextMessage("Dear "+sanction.getApplicantName()+", "
					+ ""
					+ ""
					+ "YOur Sanction letter from UIBS is attached below.");
			helper.setTo(sanction.getEmail());
			helper.setFrom(e.getFromEmail());
			helper.setText(e.getTextMessage());
			helper.setSubject(e.getSubject());
			//FileSystemResource f = new FileSystemResource("C://Users/vyenk/Downloads/Vyenktesh.pdf");
			//System.out.println(f.getFilename());
			helper.addAttachment(f.getOriginalFilename(), f);
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}

		sender.send(message);
		System.out.println("MAIL WITH ATTACHMENT SENT");
	}
}
