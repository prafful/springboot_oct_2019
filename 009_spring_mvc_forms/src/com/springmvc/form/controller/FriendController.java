package com.springmvc.form.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.form.pojo.Friend;

@Controller
public class FriendController {
	
	List<Friend> friends = new ArrayList<Friend>();
	
	@RequestMapping("/home")
	public ModelAndView welcome() {
		//Use modelandview to link model (POJO) with view (.jsp)
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", "Prafful Daga");
		mv.addObject("location", "Bengaluru");
		mv.setViewName("welcome");
		return mv;
		
	}
	
	@RequestMapping(value = "/openaddfriend", method = RequestMethod.GET)
	public ModelAndView openAddFriendForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addfriend");
		//Command Object - a JavaBean which will be 
		//populated with the data from your forms
		mv.addObject("command", new Friend());
		return mv;
	}
	
	@RequestMapping("/openviewfriend")
	public ModelAndView openViewFriendPage() {
		//get the data or friends from the database!
		//here, we are retrieving data from collection!
		ModelAndView mv = new ModelAndView();
		System.out.println("Count of friends: " + friends.size());
		mv.setViewName("viewfriend");
		mv.addObject("allfriends", friends);
		return mv;
	}
	
	@RequestMapping( value = "/addnewfriend", method = RequestMethod.POST)
	public ModelAndView addFriend(@ModelAttribute("friend") Friend friend ) {
		System.out.println("Name: "  + friend.getName());
		System.out.println("Location: " + friend.getLocation());
		System.out.println("Years: " + friend.getYears());
		friends.add(friend);
		return new ModelAndView("redirect:/openviewfriend.spring");
		
		
	}
	
	
	

}
