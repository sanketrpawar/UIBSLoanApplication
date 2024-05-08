package com.uibs.enquiry.service;

import java.util.List;

import com.uibs.enquiry.model.Email;
import com.uibs.enquiry.model.Enquiry;

public interface EnquiryService {

	public Enquiry saveEnquiry(Enquiry enquiry);

	public void sendEnquiryMail(Enquiry enquiry, Email email);

	public List<Enquiry> getEnquiries();

	public Enquiry getEnquiry(long id);

}
