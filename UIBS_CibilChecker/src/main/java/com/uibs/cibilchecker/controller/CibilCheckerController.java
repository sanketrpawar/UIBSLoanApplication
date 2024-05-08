package com.uibs.cibilchecker.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uibs.cibilchecker.model.Email;
import com.uibs.cibilchecker.model.User;
import com.uibs.cibilchecker.service.CibilCheckerService;
import com.uibs.cibilchecker.utility.CibilEmailUtility;

@RestController
public class CibilCheckerController {

	@Autowired
	CibilCheckerService cibilCheckerService;
	
	@Autowired
	CibilEmailUtility enquiryEmailUtility;
	
	@PostMapping("/cibil_otp_generation")
	public ResponseEntity<User> cibilOtpGeneration(@RequestBody User user, Email email){
		
		int min = 111111;
		int max = 999999;

		int f = min + (int) (Math.random() * ((max - min) + 1));
		
		System.out.println(f);
		
		user.setOtp(f);
		
		cibilCheckerService.checkCibil(user);
		
		enquiryEmailUtility.sendSimpleMail(user, email, f);	
		
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@GetMapping("/get_cibil_user/{id}")
	public ResponseEntity<User> getCibilUser(@PathVariable long id, @RequestParam long otp){
		
		User cibilUser = cibilCheckerService.getCibilUser(id);
		System.out.println(cibilUser.getOtp());

		//cibilUser.getotp == otp
		if(cibilUser.getOtp()==otp) {
			
			int min = 600;
			int max = 999;

			int f = min + (int) (Math.random() * ((max - min) + 1));
			
			System.out.println(f);
			
			LocalDateTime now = LocalDateTime.now();  
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
			String format2 = now.format(format);
			System.out.println("aaa");
			cibilUser.getCibilScore().setCibilScore(f);
			System.out.println("bbb");
			cibilUser.getCibilScore().setCibilScoreDate(format2);
		}
		else {
			System.out.println("invalid otp");
		}
		return new ResponseEntity<User>(cibilUser, HttpStatus.OK);
	}
}
