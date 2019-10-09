package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	@RequestMapping("/")
	public String welcome() {
		return "Hello from STS Again!";
	}
	
}
