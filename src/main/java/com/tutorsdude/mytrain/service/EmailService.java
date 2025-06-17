package com.tutorsdude.mytrain.service;

public interface EmailService {
	
	public void sendBookingEmail(String toEmail, String subject, String body);

}
