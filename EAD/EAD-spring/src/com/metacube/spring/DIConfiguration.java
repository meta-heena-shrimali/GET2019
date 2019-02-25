package com.metacube.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 
public class DIConfiguration {
	@Bean
    public EmailService email( ) {
        return new EmailService("hello how are you says the bean","ABC");
    }   
	

}
