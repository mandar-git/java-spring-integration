package com.test.spring_aggregator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

import com.test.spring_aggregator.model.Payment;
import com.test.spring_aggregator.service.MessageGateway;
import com.test.spring_aggregator.service.PaymentGateway;

public class AppMain {

	public static void main(String[] args){
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		
		//Test aggregation of string messages
		
		MessageGateway gateway = ctx.getBean("gatewaybean",MessageGateway.class);
		String message1 = "message-1" ;
		String message2 = "msg-2";
		String message3 = "message-3";
		Message<String> m1 = new GenericMessage<String>(message1);
		gateway.process(m1);
		
		Message<String> m2 = new GenericMessage<String>(message2);
		Message<String> m3 = new GenericMessage<String>(message3);
		gateway.process(m2);
		gateway.process(m3);
		
		
		//Test aggregation of Messages with payload as Payment object
		
		PaymentGateway paygate = ctx.getBean("paygatewaybean",PaymentGateway.class);
		Payment p1 = new Payment("SINGLE",11,"debit");
		Payment p2 = new Payment("RECURRING",25,"achd");
		Payment p3 = new Payment("SINGLE",32,"checkd");
		Payment p4 = new Payment("RECURRING",15,"card");
		
		Message<Payment> mp1 = new GenericMessage<Payment>(p1);
		paygate.process(mp1);
		
		Message<Payment> mp2 = new GenericMessage<Payment>(p2);
		Message<Payment> mp3 = new GenericMessage<Payment>(p3);
		Message<Payment> mp4 = new GenericMessage<Payment>(p4);
		
		paygate.process(mp2);
		paygate.process(mp3);
		paygate.process(mp4);
	}
	
}
