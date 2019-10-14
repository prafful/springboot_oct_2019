package com.springmvc.beginner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/view")
public class FirstSpringMVCController {
	
	@RequestMapping("/")
	public String sayHello() {
		/**
		 * It will look for handler mapping and use prefix + belowstring + suffix
		 * to create the file path.
		 * It will use the file path to send back as response.
		 */
		 // /WEB-INF/myviews/hello.jsp  
		return "welcome";
	}
	
	

}
