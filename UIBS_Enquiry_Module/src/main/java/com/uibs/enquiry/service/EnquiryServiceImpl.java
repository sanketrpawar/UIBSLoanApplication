package com.uibs.enquiry.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uibs.enquiry.exception.EnquiryNotSubmitException;
import com.uibs.enquiry.model.Email;
import com.uibs.enquiry.model.Enquiry;
import com.uibs.enquiry.repository.EnquiryRepository;
import com.uibs.enquiry.utility.EnquiryEmailUtility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	EnquiryRepository enquiryRepository;
	
	@Autowired
	EnquiryEmailUtility enquiryServiceUtility;

	@Override
	public Enquiry saveEnquiry(Enquiry enquiry) {

		log.info("executing saveEnquiry method of EnquiryServiceImpl");

		List<String> li = new ArrayList<String>();
		List<Enquiry> al = enquiryRepository.findAll();

		for (Enquiry a : al) {
			li.add(a.getPancardNo());
		}

		if (li.contains(enquiry.getPancardNo())) {
			
			log.info("EnquiryNotSubmitException Started " + enquiry.getPancardNo() + "user already exist");
			throw new EnquiryNotSubmitException("This Pan card is already stored in our database. Please enter again");
		} else {
			
			LocalDateTime now = LocalDateTime.now();  
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); 
			String dateAndTime = now.format(format);
			
			log.info("saveEnquiry method of EnquiryServiceImpl running as expected. Enquiry saved into database");
			Enquiry saveEnquiry = enquiryRepository.save(enquiry);
			return saveEnquiry;
		}
		
	}

	@Override
	public void sendEnquiryMail(Enquiry enquiry, Email email) {
		
		log.info("executing sendEnquiryMail method of EnquiryServiceImpl");
		enquiryServiceUtility.sendSimpleMail(enquiry, email);
	}

	@Override
	public List<Enquiry> getEnquiries() {

		log.info("executing getEnquiries method of EnquiryServiceImpl");
		List<Enquiry> enquiryList = enquiryRepository.findAll();
		return enquiryList;
	}

	@Override
	public Enquiry getEnquiry(long id) {

		log.info("executing getEnquiry method of EnquiryServiceImpl");
		Optional<Enquiry> findById = enquiryRepository.findById(id);
		
		return findById.get();
	}

}
