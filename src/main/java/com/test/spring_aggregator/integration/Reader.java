package com.test.spring_aggregator.integration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.messaging.Message;

import com.test.spring_aggregator.model.Payment;

public class Reader {
	
	
	public void process(Message<List<String>> message){
		
		System.out.println("READER");
		List<String> msglist = new ArrayList<>();
		msglist = message.getPayload();
		for(String  msg: msglist){
			System.out.println(msg + " ;");
		}
	}
	
	public void processPayment(Message<List<Payment>> paymessage){
		
		System.out.println("READER-PAYMENTS");
		List<Payment> payments = new ArrayList<>();
		payments = paymessage.getPayload();
		for(Payment pay: payments){
			System.out.println(pay.toString());
		}
	}

}
