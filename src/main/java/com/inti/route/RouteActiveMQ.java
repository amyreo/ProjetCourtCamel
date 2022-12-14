package com.inti.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;


import com.inti.process.ProcessGetActiveMQ;
import com.inti.process.ProcessorAMQRL;
import com.inti.process.ProcessGetActiveMQ;

@Service
public class RouteActiveMQ extends RouteBuilder {
@Override
public void configure() throws Exception {
	
			from("direct:select")
			.setBody(constant("select * from ClientCamel"))
			.to("jdbc:dataSource")
			.process(new ProcessGetActiveMQ())
			.to("seda:traitement");
			
			// eip Content Based Router
			from("direct:traitement") //ou direct:test et on met le producerTemplate da ns le main
			.split().tokenize("\n")
			.setBody(constant("select * from ClientCamel"))
			.choice()
			 .when(body().contains("Stylo"))
			 .to("jms:queue:my_queue_FD_Stylo")
			.otherwise()
			 .to("jms:queue:my_queue_FD_Cle");
			
			
			// eip – Recipient List
			from("direct:traitement")
			.split().tokenize("\n")
			.process(new Processor() {
				
				@Override
				public void process(Exchange exchange) throws Exception {
					// TODO Auto-generated method stub
					System.out.println(exchange.getIn().getBody(String.class));
				}
			})
			.process(new ProcessorAMQRL())
			.recipientList(header("queue"));

	

}
}