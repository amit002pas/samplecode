package com.example.demo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class Rest {

	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub

		String uri = "http://blr-iae1.corp.yodlee.com:8180/hammer/R/A/L";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		String credential = "{\"username\":\"akumar23\",\"password\":\"Aadiku@632\"}";
		HttpEntity<String> entity = new HttpEntity<String>(credential);
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
		String data = response.getBody() + "";
		JSONObject json = new JSONObject(data);
		String token = json.getString("token");
		System.out.println("Token Generated: " + token);

		uri = "http://blr-iae1.corp.yodlee.com:8180/hammer/R/MD";

		//String create = "{\"feature\":\"MaintenanceSchedule\",\"operation\":\"Add\",\"data\":{\"sumInfoId\":19588,\"startDateTime\":\"01-12-2018 05:30\",\"endDateTime\":\"01-12-2018 07:30\",\"expiryDate\":\"12-12-2018\",\"recurrance\":\"YEARLY\",\"notes\":\"TESTING\"}}";
		 String fetch =
		 "{\"feature\":\"MaintenanceSchedule\",\"operation\":\"Fetch\",\"data\":{\"sumInfoId\":5}}";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + token);
		HttpEntity<String> entity1 = new HttpEntity<String>(fetch, headers);

		// send request and parse result
		ResponseEntity<String> response1 = restTemplate.exchange(uri, HttpMethod.POST, entity1, String.class);

		//System.out.println(response1);
		JSONObject json1 = new JSONObject(response1.getBody());
		//System.out.println("$$$$$$$$$$$$$$$$$ "+json1.getJSONObject("status"));
		
		 JSONArray c = json1.getJSONObject("responseData").getJSONArray("maintenanceWindows");
		System.out.println(json1);
	System.out.println("Length :"+json1.length());
		 for (int i = 0 ; i < c.length(); i++) {
		        JSONObject obj = c.getJSONObject(i);
		        System.out.println("Id :"+obj.get("maintenanceScheduleId"));
		}
	}

}
