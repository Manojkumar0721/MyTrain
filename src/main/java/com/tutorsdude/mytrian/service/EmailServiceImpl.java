package com.tutorsdude.mytrian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendBookingEmail(String toEmail, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("manu07y@gmail.com");
		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(body);
		
		System.out.println("Sending email to: " + toEmail);
		mailSender.send(message);
		System.out.println("Email sent successfully");
	}

}
