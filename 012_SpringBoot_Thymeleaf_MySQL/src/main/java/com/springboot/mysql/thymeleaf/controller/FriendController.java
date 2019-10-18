package com.springboot.mysql.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.mysql.thymeleaf.entity.FriendEntity;
import com.springboot.mysql.thymeleaf.repository.FriendRepository;

@Controller
public class FriendController {
	
	@Autowired
	private FriendRepository friendRepository;

	@RequestMapping("/")
	public String welcome() {
		return "welcome";
	}
	@RequestMapping("/open_addfriend_page")
	public String openAddFriendPage(Model m) {
		m.addAttribute("friend", new FriendEntity());
		return "add_friend";
	}
	
	@RequestMapping(value = "/addfriend", method = RequestMethod.POST)
	public String addFriend(FriendEntity friend,Model m) {
		friendRepository.save(friend);
		return "view_friend";
	}
}
