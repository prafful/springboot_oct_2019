package com.example.demo.steps;

import org.springframework.batch.item.ItemProcessor;

import com.example.demo.entity.Friend;

public class FriendProcessor implements ItemProcessor<Friend, Friend> {

	@Override
	public Friend process(Friend friend) throws Exception {
		// TODO Auto-generated method stub
		Friend newFriend = new Friend(friend.getId(), 
									friend.getName(), 
									friend.getLocation(), 
									friend.getYear());
		
		
		
		return newFriend;
	}

}
