package com.vsk.stsweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

	@Autowired
	private JavaMailSender javaMailSender;
	

	public String sendEmail(String toEmail, String subject, String body) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			
			message.setFrom("globalgroupware5@gmail.com");
			message.setTo(toEmail);
			message.setSubject(subject);
			message.setText(body);
			
			javaMailSender.send(message);
			return "Mail sent";
			
		} catch (Exception e) {
			return "Exception in mail : "+e;
		}
	}
}
