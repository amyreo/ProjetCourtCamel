package com.inti.controller;

import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.Product;

@RestController
public class ProductController {
	
	@Autowired
	ProducerTemplate producerTemplate;
	
	@GetMapping("/ListeProduit")
	public List<Product> listeProduit()
	{
		return producerTemplate.requestBody("direct:select", null, List.class);
	}
	
	@GetMapping("repartitionProduit")
	public void repartitionProduit ()
	{
		//return producerTemplate.requestBody("direct:select", null, List.class);
	}

}
