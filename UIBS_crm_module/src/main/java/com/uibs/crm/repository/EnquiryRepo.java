package com.uibs.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uibs.crm.models.Enquiry;

public interface EnquiryRepo extends JpaRepository<Enquiry, Long>{

}