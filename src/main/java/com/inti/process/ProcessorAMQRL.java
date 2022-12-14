package com.inti.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ProcessorAMQRL implements Processor {
@Override
public void process(Exchange exchange) throws Exception {
	// TODO Auto-generated method stub
	String message = exchange.getIn().getBody(String.class);
	
	message ="jms:queue:Queueu_Ex_7" + message;
	exchange.getIn().setHeader("queue", message);
}
	
}
