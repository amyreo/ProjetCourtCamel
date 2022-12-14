package com.inti.configuration;

import java.util.Arrays;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;

import com.inti.component.MessageSubscriberDeux;
import com.inti.component.MessageSubscriberUn;

@Configuration
@ComponentScan(basePackages = "com.inti")
public class JmsConfig {

	@Value("${JMS.BROKER.URL}")
	private String DEFAULT_BROKER_URL;

	@Value("${JMS.TOPIC.NAME}")
	private String TOPIC_NAME;
	
	@Autowired
	private MessageSubscriberUn messageSubscriberUn;
	
	@Autowired
	private MessageSubscriberDeux messageSubscriberDeux;

	@Bean
	public ConnectionFactory connectionFactory() throws JMSException {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
		connectionFactory.createConnection("admin", "admin");
		connectionFactory.setTrustedPackages(Arrays.asList("com.inti"));
		return connectionFactory;
	}

	@Bean
	public JmsTemplate jmsTemplate() throws JMSException {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		template.setDefaultDestinationName(TOPIC_NAME);
		template.setPubSubDomain(true); // On créé un Topic au lieu d'une Queue
		return template;
	}
	
	@Bean(name = "messageContainerUn")
	public MessageListenerContainer getContainerUn() throws JMSException {
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(connectionFactory());
		container.setDestinationName(TOPIC_NAME);
		container.setPubSubDomain(true);
		container.setMessageListener(messageSubscriberUn);
		return container;

	}
	
	@Bean(name = "messageContainerDeux")
	public MessageListenerContainer getContainerDeux() throws JMSException {
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(connectionFactory());
		container.setDestinationName(TOPIC_NAME);
		container.setPubSubDomain(true);
		container.setMessageListener(messageSubscriberDeux);
		return container;

	}
}
