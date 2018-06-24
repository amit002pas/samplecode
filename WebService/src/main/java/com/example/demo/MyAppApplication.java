package com.example.demo;


import java.awt.PageAttributes.MediaType;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Configuration
@SpringBootApplication
public class MyAppApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MyAppApplication.class, args);
	}
	public void run(String ...arg) throws JSONException  {
			
			System.out.println("i m in run ......");
			/*String url="https://firemem.tools.yodlee.com/hammer/R/A/L";
	    	String username="akumar23";
	    	String password="Aadiku@632";
		 
		    User newEmployee = new User();
		    newEmployee.setUsername(username);
		    newEmployee.setPassword(password);
		    JSONObject jo = new JSONObject();
	         
	        // putting data to JSONObject
	        jo.put("username", username);
	        jo.put("password", password);
	      //  System.out.println(jo);
		    System.out.println("i m here..........");
		    RestTemplate restTemplate = new RestTemplate();
		    User result = restTemplate.postForObject( url, jo, User.class);
		 
		    System.out.println("aaa"+result);*/
			
			//HttpHeaders headers = new HttpHeaders();
			//headers.setContentType(application/json);
			//String input = "{\"name\":\"name\",\"email\":\"email@gmail.com\"}";
			//System.out.println("string :"+input);
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			 Map<String, String> map = new HashMap<>();
		     map.put("Content-Type", "application/json");
		     headers.setAll(map);
			
			 Map<String, String> req_payload = new HashMap();
			 req_payload.put("username", "akumahr23");
			 req_payload.put("password", "Aadiku@632");
			 HttpEntity<?> request = new HttpEntity<>(req_payload, headers);
			 String url="https://firemem.tools.yodlee.com/hammer/R/A/L";
			ResponseEntity<?> response = new RestTemplate().postForEntity(url, request, String.class);
			String data=response.getBody()+"";
			JSONObject json = new JSONObject(data);  
			String token=json.getString("token");
			String auth = "Bearer "+token;
			System.out.println("^^^^^^^^^^ "+auth);
			map = new HashMap<>();
			map.put("accept", "application/json");
			map.put("Authorization", auth);
			
			HttpHeaders header = new HttpHeaders();
			header.add("Authorization", auth);
			url = "https://firemem.tools.yodlee.com/hammer/R/V";
			
			HttpEntity<String> newRequest = new HttpEntity<String>(header);
			
			System.out.println("check->"+new RestTemplate().postForObject(url, newRequest, String.class));
			
			

			
		//	System.out.println(response);
		
		
	}
	@Bean
	public Check d() {
		return new Check();
	}
}
