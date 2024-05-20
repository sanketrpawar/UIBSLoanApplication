package com.uibs.cm.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uibs.cm.controller.repository.SanctionLetterRepository;
import com.uibs.cm.controller.service.SanctionLetterService;
import com.uibs.cm.model.Email;
import com.uibs.cm.model.SanctionLetter;
import com.uibs.cm.utility.EmailSenderUtility;

import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/uibs")
@RestController
public class CM_Controller {

	@Autowired
	SanctionLetterService sanctionLetterService;

	@Value("${spring.mail.username}")
	private String fromMail;

	@Autowired
	EmailSenderUtility emailSenderUtility;
	
	@Autowired
	SanctionLetterRepository sanctionLetterRepository;

	@PostMapping("/postSanctionLetter")
	public ResponseEntity<SanctionLetter> postSanctionLetter(@RequestPart("sanction") String json,
			@RequestPart("file") MultipartFile file) throws IOException, MessagingException {

		Email e = new Email();
		e.setFromEmail(fromMail);

		ObjectMapper om = new ObjectMapper();
		SanctionLetter sanction = om.readValue(json, SanctionLetter.class);
		sanction.setLetter(file.getBytes());

		SanctionLetter saveSanctionLetter = sanctionLetterService.saveSanctionLetter(sanction);
		emailSenderUtility.sendSanctionLetterWithAttachment(saveSanctionLetter, e, file);

		return new ResponseEntity<SanctionLetter>(saveSanctionLetter, HttpStatus.CREATED);
	}

	@GetMapping("/getLoanDetailsFromOE/{id}")
	public ResponseEntity<SanctionLetter> getLoanDetailsFromOE(@PathVariable long id) {

		SanctionLetter findById = sanctionLetterRepository.findById(id).get();
		return new ResponseEntity<SanctionLetter>(findById, HttpStatus.OK);
	}
}
