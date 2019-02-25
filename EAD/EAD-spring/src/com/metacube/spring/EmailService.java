package com.metacube.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class EmailService implements MessageService{
    private String message;
    private String receiver;
    
    @Autowired
    public EmailService(String message ,String receiver) {
     
    	super();
        this.message=message;
        this.receiver=receiver;
    }
    
    @Override
    public void sendMessage(String message, String receiver) {
        System.out.println(this.getReceiver() + " receive the message : \n "+ this.getMessage() +" \n by Email Service");      
    }

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
}
