package com.inti.component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

import com.inti.Product;

@Component
public class MessageSubscriberUn implements MessageListener {

	@Override
	public void onMessage(Message message) {
		
		System.out.println("test test un deux");
		
		try {
			TextMessage tm = (TextMessage) message;
			String m = tm.getText();
			ObjectMessage om = (ObjectMessage) message;
			Product prod = (Product) om.getObject();
			System.out.println("Message reçu depuis le premier subscriber : " + prod.toString());
			System.out.println(message.getBody(String.class));
			
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
