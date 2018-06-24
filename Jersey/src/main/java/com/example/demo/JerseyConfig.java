package com.example.demo;

import javax.inject.Named;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.scheduling.annotation.EnableScheduling;

@Named
@EnableScheduling
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		// property(GreetingController.TEMPLATE_BASE_PATH, "/templates");
		register(GreetingController.class);
		 register(LoggingFilter.class);
	       // register(GsonMessageBodyHandler.class);
	 
	        //Register Auth Filter here
	     //   register(AuthenticationFilter.class);
		
	}
}
