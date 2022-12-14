package com.inti.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

import com.inti.process.ProcessGetActiveMQ;
@Service
public class RouteActiveMQ extends RouteBuilder {
@Override
public void configure() throws Exception {
	
	
	from("direct:select")
	.setBody(constant("select * from ProductCamel"))
	.to("jdbc:dataSource")
	.process(new ProcessGetActiveMQ())
	.to("seda:traitement");
	
	
	from("direct:traitement") //ou direct:test et on met le producerTemplate da ns le main
	.split().tokenize("\n")
	.choice()
	 .when(body().contains("Stylo"))
	 .to("jms:queue:my_queue_FD_Stylo")
	.otherwise()
	 .to("jms:queue:my_queue_FD_Cle");	
	
}
}
//producer template et rappeler a partir de traitement