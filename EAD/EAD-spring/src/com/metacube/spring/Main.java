package com.metacube.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext(
				"MyXMLApplication.xml");

		TwitterService twitter = (TwitterService) factory.getBean("twitter");
		twitter.sendMessage("hello how are you said by aplication context", "XYZ");

		ApplicationContext ctx = new AnnotationConfigApplicationContext(DIConfiguration.class);

		EmailService email = (EmailService) ctx.getBean("email");
		email.sendMessage("message", "receiver");
	}

}
