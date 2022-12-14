package com.inti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.inti.component.MessagePublisher;

@SpringBootApplication(scanBasePackages = "com.inti")
public class JmsTd2Ex1Application implements CommandLineRunner{
	
	@Autowired
	MessagePublisher messagePublisher;

	public static void main(String[] args) {
		SpringApplication.run(JmsTd2Ex1Application.class, args);
	}
	
	@Override
	public void run(String...strings) {
		Product prod = new Product(1, "Voiture", 521);
//		messagePublisher.sendMessage("Bonjour j'aime les crêpes");
		messagePublisher.sendProduct(prod);
	}

}
