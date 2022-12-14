package com.inti.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.inti.Product;

@Component
public class MessagePublisher {


	@Autowired
	JmsTemplate jmsTemplate;

	public void sendMessage(String message) {
		jmsTemplate.convertAndSend(message);
	}
	
	public void sendProduct(Product prod) {
		jmsTemplate.convertAndSend(prod);
	}

}
