package com.inti.component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

import com.inti.Product;

@Component
public class MessageSubscriberDeux implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			TextMessage tm = (TextMessage) message;
			String m = tm.getText();
			System.out.println("Message reçu depuis le second subscriber : ");
//			System.out.println(message.getBody(String.class));
//
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
