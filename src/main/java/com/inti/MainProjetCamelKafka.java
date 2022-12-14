package com.inti;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.kafka.KafkaComponent;
import org.apache.camel.impl.DefaultCamelContext;

import com.inti.route.RouteCamelKafka;

public class MainProjetCamelKafka {

	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteCamelKafka());
		
//		KafkaComponent kafka = new KafkaComponent();
//		kafka. ("localhost:9092");

//		context.addComponent("kafka", kafka);

		
		Product p1 = new Product(1, "carotte", 90);
		Product p2 = new Product(2, "potiron", 12);
		Product p3 = new Product(5, "carot", 5);
		context.start();
		
		ProducerTemplate producerTemplate = context.createProducerTemplate();
		producerTemplate.sendBody("direct:start", p1.toString());
		producerTemplate.sendBody("direct:start", p2.toString());
		producerTemplate.sendBody("direct:start", p3.toString());

	}

}
