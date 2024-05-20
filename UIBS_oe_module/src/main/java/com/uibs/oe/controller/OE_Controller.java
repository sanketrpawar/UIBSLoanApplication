package com.uibs.oe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.uibs.oe.model.CRMLoansDetails;
import com.uibs.oe.model.CustomerApplicationForm;
import com.uibs.oe.model.Enquiry;
import com.uibs.oe.model.User;
import com.uibs.oe.repository.LoansRepo;
import com.uibs.oe.repository.OE_Repository;

@CrossOrigin
@RestController
public class OE_Controller {
	
	@Autowired
	RestTemplate rt;
	
	@Autowired
	OE_Repository oe_Repository;
	
	@Autowired
	LoansRepo loansRepo;

//	@GetMapping("/cibil/{id}")
//	public Enquiry checkCibil(@PathVariable long id){
//		
//		String url = "http://localhost:1111/uibs/getEnquiry/"+id;
//		
//		Enquiry enquiry = rt.getForObject(url, Enquiry.class);
//		
//		System.out.println(enquiry);
//		
//		int min = 600;
//		int max = 999;
//
//		int f = min + (int) (Math.random() * ((max - min) + 1));
//		
//		System.out.println(f);
//		enquiry.getCibilScore().setCibilScore(f);
//		
//		LocalDateTime now = LocalDateTime.now();  
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
//		String format2 = now.format(format);
//		
//		enquiry.getCibilScore().setCibilScoreDate(format2);
//		
//		oe_Repository.save(enquiry);
//		
//		System.out.println(enquiry);
//		return enquiry;
//			
//	}
	
	
	
	@GetMapping("/cibil_check/{id}")
	public User checkCibilScore(@PathVariable long id, @RequestParam("otp") long otp) {
		
		String url = "http://localhost:3331/get_cibil_user/"+id+"?otp="+otp;
		
		User user = rt.getForObject(url, User.class);
		System.out.println(user);
		
		return user;
	}
	
	@GetMapping("/getEnquiriesFromCRM")
	public ResponseEntity<List<Enquiry>> getEnquiriesFromCRM(){
		
		String url = "http://localhost:3333/forward_to_oe";
		
		List<Enquiry> forObject = rt.getForObject(url, List.class);
		
		return new ResponseEntity<List<Enquiry>>(forObject, HttpStatus.OK);	
	}
	
//	@GetMapping("/getLoansFromCRM")
//	public ResponseEntity<List<CRMLoansDetails>> getLoansFromCRM(){
//		
//		List<CRMLoansDetails> findAll = loansRepo.findAll();
//		
//		return new ResponseEntity<List<CRMLoansDetails>>(findAll, HttpStatus.OK);
//	}
	
	@GetMapping("/getLoansFromCRM")
	public ResponseEntity<List> getLoansfromCRM(){
		
		String url = "http://localhost:3333/getLoansFromCRM";
		
		List<CRMLoansDetails> forObject = rt.getForObject(url, List.class);
		
		String url1 = "http://localhost:5000/uibs/forwardLoansToOE";
		
		List postForObject = rt.postForObject(url1, forObject, List.class);
		
		return new ResponseEntity<List>(postForObject, HttpStatus.OK);
	}
	
	@GetMapping("/viewDetails/{appId}")
	public ResponseEntity<CustomerApplicationForm> getViewDetails(@PathVariable long appId){
		
		String url = "http://localhost:5000/uibs/getAllDetails/"+appId;
	
		CustomerApplicationForm forObject = rt.getForObject(url, CustomerApplicationForm.class);
		
		return new ResponseEntity<CustomerApplicationForm>(forObject, HttpStatus.OK);
	}
}
