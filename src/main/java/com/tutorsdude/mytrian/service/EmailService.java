package com.tutorsdude.mytrian.service;

public interface EmailService {
	
	public void sendBookingEmail(String toEmail, String subject, String body);

}
