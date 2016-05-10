package com.cmpe275.util;

import java.util.Random;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;


public class VerifyCodeGeneratorImpl implements VerifyCodeGenrerator {

	private MailSender mailSender;
	private SimpleMailMessage simpleMailMessage;
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}


	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}
		
	
	@Override
	public void codeGenerator() {
		 SimpleMailMessage message = new SimpleMailMessage(simpleMailMessage);
	        
		Random randomGenerator = new Random();
		int num = randomGenerator.nextInt(9000) + 10000;
		message.setText(String.format(
                simpleMailMessage.getText(),num));
        mailSender.send(message);
	}
	

}
