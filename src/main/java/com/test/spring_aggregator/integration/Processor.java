package com.test.spring_aggregator.integration;

import org.springframework.messaging.Message;

import com.test.spring_aggregator.model.Payment;

public class Processor {
	 
	public Message<String> process(Message<String> message){
		String payload = message.getPayload();
		return message;
	}
	
	public Message<Payment> processPayment(Message<Payment> message){
		Payment pay  = message.getPayload();
		return message ;
	}

}

