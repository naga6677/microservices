package com.microservices.learning.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {

	@RequestMapping(value = "/sayhello", method = RequestMethod.GET)
	public String sayHello() {

		return "Hello, Welcome to the Microservices world!!";
	}
}
