package com.uibs.crm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.uibs.crm.models.CRMLoansDetails;
import com.uibs.crm.models.CustomerApplicationForm;
import com.uibs.crm.models.Enquiry;
import com.uibs.crm.models.SuccessMsg;
import com.uibs.crm.repository.CRM_Repository;
import com.uibs.crm.repository.EnquiryRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
public class CrmController {
	
	@Autowired
	RestTemplate rt;
	
	@Value("${spring.mail.username}")
	private String fromMail;
	
	@Autowired
	CRM_Repository crmRepository;
	
	@Autowired
	EnquiryRepo enquiryRepo;
	
	@PostMapping("/saveEnquiry")
	public ResponseEntity<Enquiry> saveEnquiry(@RequestBody Enquiry enquiry){
		log.info("saveEq     "+enquiry);
		String url = "http://localhost:1111/uibs/saveEnquiry";
		
		Enquiry en = rt.postForObject(url,enquiry, Enquiry.class);
		log.info("after getEnquires");
		return new ResponseEntity<Enquiry>(en, HttpStatus.CREATED);
	}
	
	@GetMapping("/getEnquiries")
	public ResponseEntity<List<Enquiry>> getEnquiries(){
		
		String url = "http://localhost:1111/uibs/getEnquiries";
		
		List<Enquiry> enquiryList = rt.getForObject(url, List.class);
		
		return new ResponseEntity<List<Enquiry>>(enquiryList, HttpStatus.OK); 
	} 

	@PostMapping("/sendToOE")
	public ResponseEntity<List<Enquiry>> sendToOE(@RequestBody List<Enquiry> enquiryList){
		
		List<Enquiry> list = enquiryRepo.saveAll(enquiryList);
		
		SuccessMsg m = new SuccessMsg();
		m.setMsg("Enquiry forwarded to OE");
		
		return new ResponseEntity<List<Enquiry>>(list, HttpStatus.OK); 
		
	}
	
	@GetMapping("/forward_to_oe")
	public ResponseEntity<List<Enquiry>> forwardToOe(){
		
		List<Enquiry> findAll = enquiryRepo.findAll();
		
		return new ResponseEntity<List<Enquiry>>(findAll, HttpStatus.OK); 
	} 
	
	@GetMapping("/getLoanApp")
	public ResponseEntity<List<CustomerApplicationForm>> getLoanApplication(){
		
		String url = "http://localhost:5000/uibs/getLoanApp";
		
		List<CustomerApplicationForm> caf = rt.getForObject(url, List.class);
		
		return new ResponseEntity<List<CustomerApplicationForm>>(caf, HttpStatus.OK); 
	}
	
	@PostMapping("/saveLoansFromCRM")
	public ResponseEntity<List<CRMLoansDetails>> saveLoansFromCRM(@RequestBody List<CustomerApplicationForm> loanFromCRM){
		
		CRMLoansDetails cd = new CRMLoansDetails();
		List<CRMLoansDetails> list = new ArrayList<>();
		
		for(CustomerApplicationForm cl : loanFromCRM) {
			cd.setApplicationNo(cl.getApplicationNo());
			cd.setCustomerName(cl.getCustomerDetails().getCustomerName());
			cd.setEmail(cl.getCustomerDetails().getEmailID());
			cd.setMobileNo(cl.getCustomerDetails().getMobileNo());
			cd.setPancardNo(cl.getCustomerDetails().getPancardNo());
			list.add(cd);		
			
		}
		
		List<CRMLoansDetails> saveAll = crmRepository.saveAll(list);
		
		return new ResponseEntity<List<CRMLoansDetails>>(saveAll, HttpStatus.CREATED);
	}
	
	@GetMapping("/getLoansFromCRM")
	public ResponseEntity<List<CRMLoansDetails>> getLoansFromCRM(){
		
		List<CRMLoansDetails> findAll = crmRepository.findAll();
		
		return new ResponseEntity<List<CRMLoansDetails>>(findAll, HttpStatus.OK);
	}
}
