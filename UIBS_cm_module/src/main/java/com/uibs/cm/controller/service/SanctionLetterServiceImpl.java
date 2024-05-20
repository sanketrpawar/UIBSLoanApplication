package com.uibs.cm.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uibs.cm.controller.repository.SanctionLetterRepository;
import com.uibs.cm.model.SanctionLetter;

@Service
public class SanctionLetterServiceImpl implements SanctionLetterService{

	@Autowired
	SanctionLetterRepository sanctionLetterRepository;
	
	@Override
	public SanctionLetter saveSanctionLetter(SanctionLetter sanctionLetter) {
		
		SanctionLetter sl = sanctionLetterRepository.save(sanctionLetter);
		return sl;
	}

	
}
