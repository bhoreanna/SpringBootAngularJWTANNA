package com.anna.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class NotificationService {
	
	JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender)
	{
		this.javaMailSender=javaMailSender;
	}
	@Async
	public void sendNotication(String toMail)
	{
		System.out.println("ToMail Id: "+toMail);
		try
		{
			SimpleMailMessage mail=new SimpleMailMessage();
			LocalDateTime today = LocalDateTime.now();
			System.out.println("Current DateTime="+today);
			
			//Current Date using LocalDate and LocalTime
			today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
			System.out.println("Current DateTime="+today);
			System.out.println("Local date: ");
			mail.setTo(toMail);
			mail.setFrom("anna.bhore0@gmail.com");
			mail.setSubject("Login Mail Application Using Spring Boot");
			
			
			
			mail.setText("You Are login Angular Application Made BY: Mr. ANNA BHORE"+today);
			javaMailSender.send(mail);
			System.out.println("Mail Send Sucessfully");

		}catch(Exception e)
		{
			System.out.println("Exception"+e.getMessage());
		}
	}

}
