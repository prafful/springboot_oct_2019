package com.springboot.rest.restcontroller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.pojo.Friend;

@RestController
@RequestMapping("/api/v1/friend")
public class MyFirstRestController {

		List friends = new ArrayList<Friend>();
		
		public MyFirstRestController(){
			friends.add(new Friend(1, "Oki", 4));
			friends.add(new Friend(2, "Miko", 2));
			friends.add(new Friend(3, "Uta", 8));
			friends.add(new Friend(4, "Jun", 13));
		}
	
		@RequestMapping("/")
		public String welcome() {
			return "Hello from Spring Boot REST!";
		}
		
		@RequestMapping("/all")
		public List getAllFriends() {
			return friends;
		}
		
		/**
		 * Receive request in format
		 * /api/v1/friend/{id}
		 * @return
		 */
		@RequestMapping("/{id}")
		public Friend getFriendById(@PathVariable("id") int id) {
			System.out.println("Get friend with Id: " + id);
			for(int i = 0; i< friends.size(); i++) {
				Friend f = (Friend) friends.get(i);
				if(f.getId() == id) {
					return f;
				}
			}
			return null;
		}
		
		@RequestMapping(value = "/add", method = RequestMethod.POST)
		public List addFriend(@RequestBody Friend f) {
			friends.add(f);
			return friends;
		}
		
		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		public List deleteFriend(@PathVariable int id) {
			System.out.println("Delete with id: " + id);
			for(int i = 0; i< friends.size(); i++) {
				Friend f = (Friend) friends.get(i);
				if(f.getId() == id) {
					friends.remove(i);
				}
			}
			return friends;
		}
	
}
