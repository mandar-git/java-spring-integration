package com.test.spring_aggregator.integration;

import java.util.List;
import java.util.ArrayList;

import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.CorrelationStrategy;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ReleaseStrategy;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.support.MessageBuilder;

import com.test.spring_aggregator.model.Payment;

@MessageEndpoint
public class AggregatorTest {
	
	private String payType;
	
	@CorrelationStrategy
	public String correlate(@Header("PAY_TYPE") String payType){
		return payType;
	}
	
	
	@ReleaseStrategy
	public boolean canRelease(List<Message<Payment>> messages){
		boolean isComplete = false;
		for(Message<Payment> message : messages){
			if(message.getHeaders().containsValue("EOM")){
				isComplete = true;
			}
		}
		return isComplete;
	}
	  
	@Aggregator
	public Message<List<Payment>> groupMessages(List<Message<Payment>> messagelist){
		
		List<Payment> paylist = new ArrayList<>();
		for(Message<Payment> msg : messagelist){
			paylist.add(msg.getPayload());
		}
		return MessageBuilder.withPayload(paylist).setHeader("PAY_TYPE", payType).build();
	}
}
