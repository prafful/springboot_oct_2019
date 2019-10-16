package com.springmvc.hibernateapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.hibernateapp.entity.FriendEntity;
import com.springmvc.hibernateapp.service.FriendService;

@Controller
public class FriendController {
	
	@Autowired
	private FriendService friendService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/openaddfriend")
	public ModelAndView openAddFriendPage() {
		return new ModelAndView("addfriend", "command", new FriendEntity());
	}
	
	@RequestMapping("/openviewfriend")
	public ModelAndView openViewFriendPage() {
		
		List<FriendEntity> allfriends = friendService.getAllFriends();
		
		return new ModelAndView("viewfriend", "friends", allfriends);
	}
	
	@RequestMapping(value = "addnewfriend", method = RequestMethod.POST)
	public ModelAndView addNewFriend(@ModelAttribute("friend") FriendEntity fe) {
		
		friendService.addNewFriend(fe);
		
		
		return new ModelAndView("redirect:/openviewfriend");
		
	}
	
}
