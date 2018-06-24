package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class Test {
	@Autowired
	Check cmd;
	
	@Value("amit")
	private String str;
	
	
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public ResponseEntity<String> createEmployee(@RequestBody User employee)
	{
	    System.out.println(employee);
	    return new ResponseEntity(HttpStatus.CREATED);
	}
}
