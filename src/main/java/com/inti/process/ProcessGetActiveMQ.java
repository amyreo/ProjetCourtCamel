package com.inti.process;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.inti.Product;


public class ProcessGetActiveMQ implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.getIn().getBody();
		List<Product> listeClients = (List<Product>) exchange.getIn().getBody();
		exchange.getIn().setBody(listeClients);
		
	}

}
