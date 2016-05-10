package com.cmpe275.util;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfiguration {

	@Bean
	public VerifyCodeGeneratorImpl codeGenerator(){
		VerifyCodeGeneratorImpl codeGenerator = new VerifyCodeGeneratorImpl();
		codeGenerator.setSimpleMailMessage(simpleMailMessage());
		codeGenerator.setMailSender(mailSender());
		return codeGenerator;
	}
	
	@Bean
    public JavaMailSenderImpl mailSender() {
    	
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.auth","true" );
        properties.setProperty("mail.smtp.starttls.enable", "true");
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("noreplyhotelmanagementsystem@gmail.com");
        mailSender.setPassword("PassworD456");
        mailSender.setJavaMailProperties(properties);
        return mailSender;
    }

    @Bean
    public SimpleMailMessage simpleMailMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreplyhotelmanagementsystem@gmail.com");
        message.setTo("saipranesh007@gmail.com");
        message.setSubject("Verify your Email Address");
        message.setText("Dear User,\n" +
                "\n" +
                "                      Please enter the following pin :\n" +
                "\t\t       Pin : %s\n" +
                "\t\t       " +
                "\t\t       To verify your email!. We are looking forward to see you :)");
        return message;
    }
}
