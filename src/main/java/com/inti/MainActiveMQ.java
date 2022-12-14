package com.inti;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import com.inti.route.RouteActiveMQ;

public class MainActiveMQ {
	private static String url = "tcp://194.206.91.85:81:61616";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		CamelContext context = new DefaultCamelContext();		
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		connectionFactory.createConnection("admin", "adaming2022");
		context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		context.addRoutes(new RouteActiveMQ());
	}

}
