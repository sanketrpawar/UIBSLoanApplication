package com.uibs.enquiry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.uibs.enquiry.model.Email;
import com.uibs.enquiry.model.Enquiry;
import com.uibs.enquiry.service.EnquiryService;
import com.uibs.enquiry.utility.EnquiryEmailUtility;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/uibs")
@CrossOrigin(origins = "http://localhost:63845")
public class EnquiryController {

	@Autowired
	EnquiryService enquiryService;

	@Autowired
	EnquiryEmailUtility enquiryEmailUtility;

	@Autowired
	RestTemplate rt;

	@Value("${spring.mail.username}")
	private String fromMail;

	@PostMapping(value="/saveEnquiry", consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Enquiry> postEnquiry(@Valid @RequestBody Enquiry enquiry, Email email) {

		log.info("executing postEnquiry method in EnquiryController");

		try {
			log.info("inside try block of postEnquiry method in EnquiryController");

			email.setFromEmail(fromMail);
			System.out.println(email.getFromEmail());
			Enquiry saveEnquiry = enquiryService.saveEnquiry(enquiry);
			enquiryService.sendEnquiryMail(enquiry, email);

			log.info("successfully completed try block in postEnquiry method in EnquiryController");
			return new ResponseEntity<Enquiry>(saveEnquiry, HttpStatus.CREATED);

		} catch (Exception e) {
			log.info("inside catch block of postEnquiry method in EnquiryController. Raised exception is: "
					+ e.getMessage());
			return new ResponseEntity<Enquiry>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getEnquiries")
	public ResponseEntity<List<Enquiry>> getEnquiries() {

		log.info("inside getEnquiries method of EnquiryController");

		List<Enquiry> enquiries = enquiryService.getEnquiries();

		log.info("successfully executed getEnquiries method of EnquiryController");
		return new ResponseEntity<List<Enquiry>>(enquiries, HttpStatus.OK);
	}

	@GetMapping("/getEnquiry/{id}")
	public ResponseEntity<Enquiry> getEnquiry(@PathVariable long id) {

		log.info("inside getEnquiry method of EnquiryController");

		Enquiry enquiry = enquiryService.getEnquiry(id);

		log.info("successfully executed method of EnquiryController");
		return new ResponseEntity<Enquiry>(enquiry, HttpStatus.OK);
	}
}
