package com.metacube.spring;

public class TwitterService implements MessageService {
	@Override
    public void sendMessage(String message, String receiver) {
        System.out.println(receiver + " receive the message : \n "+ message +" \n at Twitter");        
    }
}
