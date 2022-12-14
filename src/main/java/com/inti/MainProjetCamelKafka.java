package com.inti;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

import com.inti.route.RouteCamelKafka;

public class MainProjetCamelKafka {

	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteCamelKafka());
		
		Product p1 = new Product(1, "patate", 90);
		context.start();
		
		ProducerTemplate producerTemplate = context.createProducerTemplate();
		producerTemplate.sendBody("direct:start", p1.toString());

	}

}
