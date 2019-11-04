package com.example.demo.steps;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Friend;
import com.example.demo.repository.FriendRepository;

public class FriendWriter implements ItemWriter<Friend>{
	
	@Autowired
	private FriendRepository friendRepository;

	@Override
	public void write(List<? extends Friend> items) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Writing job to MySQL with length:" + items.size());
		friendRepository.saveAll(items);
;	}

}
