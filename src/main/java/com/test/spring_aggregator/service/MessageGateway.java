package com.test.spring_aggregator.service;

import org.springframework.integration.annotation.Gateway;
import org.springframework.messaging.Message;

public interface MessageGateway {
	
	@Gateway(requestChannel="stringChannel")
	public void process(Message<String> message);
}
