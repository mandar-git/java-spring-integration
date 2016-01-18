package com.test.spring_aggregator.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.messaging.Message;

import com.test.spring_aggregator.model.Payment;

public class Activator {
	
	public void process(Message<List<Payment>> message){
		
		System.out.println("SERVICE-PAYMENT");
		List<Payment> payments=  new ArrayList<Payment>();
		payments = message.getPayload();
		for(Payment pay : payments){
			System.out.println(pay.toString());
		}
	}

}
