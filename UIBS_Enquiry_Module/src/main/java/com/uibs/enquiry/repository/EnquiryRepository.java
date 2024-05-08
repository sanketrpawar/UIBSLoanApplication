package com.uibs.enquiry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uibs.enquiry.model.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Long>{

	
}
