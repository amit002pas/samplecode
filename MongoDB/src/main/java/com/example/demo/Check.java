package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class Check {
	
	@Autowired
	CommandLineRunner cmd;

	@RequestMapping("/home")
	@ResponseBody
	String fun() throws Exception
	{
		System.out.println("calling run mannually >>>>>>>>>>>>");
		//cmd.run("efr");
		return "kuch bhi";
	}
}
