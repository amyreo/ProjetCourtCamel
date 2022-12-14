package com.inti.route;

import javax.xml.bind.JAXBContext;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.converter.jaxb.JaxbDataFormat;

import com.inti.Product;

public class RouteCamelKafka extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		JaxbDataFormat xmlDataFormat = new JaxbDataFormat();
		JAXBContext con = JAXBContext.newInstance(Product.class);
		xmlDataFormat.setContext(con);
		JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Product.class);
		
		String topicName = "topic=projetCamelKafka";
		String kafkaServer = "kafka:localhost:9092";
		String zooKeeperHost = "zookeeperHost=localhost&zookeeperPort=2181";
		String serializerClass = "serializerClass=kafka.serializer.StringEncoder";
		String toKafka = new StringBuilder().append(kafkaServer).append("?")
				.append(topicName).append("&").append(zooKeeperHost).append("&")
				.append(serializerClass).toString();
		
		from("direct:start").to(toKafka);
	}

}
