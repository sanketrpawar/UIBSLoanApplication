package com.uibs.oe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.uibs.oe.model.User;
import com.uibs.oe.repository.OE_Repository;

@RestController
public class OE_Controller {
	
	@Autowired
	RestTemplate rt;
	
	@Autowired
	OE_Repository oe_Repository;

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
		
		String url = "http://localhost:3333/get_cibil_user/"+id+"?otp="+otp;
		
		User user = rt.getForObject(url, User.class);
		System.out.println(user);
		
		return user;
	}
}
