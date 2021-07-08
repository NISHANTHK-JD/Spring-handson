package com.cts.spring_learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
	
	@GetMapping(value = "/hello")
	public String sayHello()
	{
		LOGGER.info("start");
		return "Hello World!!";
		
	}

}
