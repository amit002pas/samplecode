package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
/*@ComponentScan("${base.package}")
@EntityScan("${base.package}")*/ 

public class MyApp1Application  {
	static int count=0;

	public static void main(String[] args) {
		System.out.println("inside main");
		count++;
		System.out.println(count);
		SpringApplication.run(MyApp1Application.class, args);
		System.out.println("frv");
	//	MyApp1Application.abc();
	}


	
	
//	@Scheduled(cron="*/5 * * * * *")
	//private static void abc() {
		//System.out.println("hello 1");
	//}

	
	
}
