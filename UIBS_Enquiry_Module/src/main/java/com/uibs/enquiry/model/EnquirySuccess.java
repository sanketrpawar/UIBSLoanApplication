package com.uibs.enquiry.model;

public class EnquirySuccess {

	public String subject;
	public String textMessage;
	
	public EnquirySuccess(Enquiry enquiry) {
		
		this.subject = "Enquiry Submitted Successfully";
		this.textMessage = "Dear " + enquiry.getEnquiryName() + ",\n\n"
                + "Thank you for your inquiry. If you're still interested in a loan, please apply at your earliest convenience.\n\n"
                + "Best regards,\nYour Lending Team";
	}
}
