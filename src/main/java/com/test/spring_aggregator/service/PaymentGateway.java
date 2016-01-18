package com.test.spring_aggregator.service;

import org.springframework.integration.annotation.Gateway;
import org.springframework.messaging.Message;

import com.test.spring_aggregator.model.Payment;

public interface PaymentGateway {
	
	@Gateway(requestChannel="payChannel")
	public void process(Message<Payment> message) ;

}
