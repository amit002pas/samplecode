package com.SpringCaching.SpringCaching;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * Hello world!
 *
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableCaching
@Controller
public class App {

	@Autowired
	AppRunner appRunner;
	
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    
    
    @GetMapping("hello/{id}")
    @ResponseBody
    public String fun(@PathVariable int id) throws InterruptedException {
    	
    	return appRunner.fun(id);
    }

}