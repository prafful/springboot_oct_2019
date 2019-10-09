package com.springboot.beginner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@RequestMapping("/")
	public String welcome() {
		return "Welcome to STS on " + new Date().toString();
	}
	
	@RequestMapping("/all")
	public List<String> getAllFriends() {
		
		List<String> friends = new ArrayList<String>();	
		friends.add("Piku");
		friends.add("Tiku");
		friends.add("Miku");
		
		
		return friends;
	}
	
}
