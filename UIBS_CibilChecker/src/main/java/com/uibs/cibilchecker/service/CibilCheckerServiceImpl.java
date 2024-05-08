package com.uibs.cibilchecker.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uibs.cibilchecker.model.User;
import com.uibs.cibilchecker.repository.CibilCheckerRepository;

@Service
public class CibilCheckerServiceImpl implements CibilCheckerService{

	@Autowired
	CibilCheckerRepository cibilCheckerRepository;
	
	@Override
	public void checkCibil(User user) {
		
		cibilCheckerRepository.save(user);
	}

	@Override
	public User getCibilUser(long id) {
		
		Optional<User> cibilUser = cibilCheckerRepository.findById(id);
		
		return cibilUser.get();
	}
}
