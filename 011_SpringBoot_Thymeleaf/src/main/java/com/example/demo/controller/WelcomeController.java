package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Use @Controller to create web app (template engine)
//Use @RestController to create REST API
@Controller
public class WelcomeController {

	@RequestMapping("/")
	public String welcome() {
		return "index";
	}
	
}
