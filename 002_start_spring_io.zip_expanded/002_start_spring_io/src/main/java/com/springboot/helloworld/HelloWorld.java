package com.springboot.helloworld;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	@RequestMapping("/")
	public String welcome() {
		return new Date().toString();
	}

}
