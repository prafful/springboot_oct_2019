package com.springmvc.form.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.form.pojo.Friend;

@Controller
public class FriendController {
	
	List<Friend> friends = new ArrayList<Friend>();
	
	@RequestMapping("/")
	public ModelAndView welcome() {
		//Use modelandview to link model (POJO) with view (.jsp)
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", "Prafful Daga");
		mv.addObject("location", "Bengaluru");
		mv.setViewName("welcome");
		return mv;
		
	}
	
	@RequestMapping("/openaddfriend")
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
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewfriend");
		return mv;
	}
	
	@RequestMapping( value = "addnewfriend", method = RequestMethod.POST)
	public ModelAndView addFriend(@ModelAttribute("frn") Friend friend ) {
		System.out.println("Name: "  + friend.getName());
		System.out.println("Location: " + friend.getLocation());
		return null;
		
	}
	

}
