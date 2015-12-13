package com.sydja.batchTuto.batch;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class SessionFactory {

	public Session getSession(){
		
		final String username = "xxxxxxxxxxxxxxxxxxxxxx";
		final String password = " ";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
		
		return session;
	}
}
