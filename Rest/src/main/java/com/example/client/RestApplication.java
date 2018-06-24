package com.example.client;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
@ComponentScan("com.yodlee.RestSwagger")

public class RestApplication {

	public static void main(String[] args) {
		System.out.println("starting....");
		SpringApplication.run(RestApplication.class, args);
		System.out.println("starting....3333");
	}
	
	
}

