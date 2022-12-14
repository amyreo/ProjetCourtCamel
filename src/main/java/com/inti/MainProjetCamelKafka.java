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
		context.start();
		
		ProducerTemplate producerTemplate = context.createProducerTemplate();
		producerTemplate.sendBody("direct:start", p1.toString());

	}

}
