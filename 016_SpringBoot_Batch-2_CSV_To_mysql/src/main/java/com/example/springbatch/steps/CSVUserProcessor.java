package com.example.springbatch.steps;

import org.springframework.batch.item.ItemProcessor;

import com.example.springbatch.pojo.User;

public class CSVUserProcessor  implements ItemProcessor<User, User>{

	@Override
	public User process(User item) throws Exception {
		// TODO Auto-generated method stub
		User u = new User();
		u.setName(item.getName().toUpperCase());
		return u;
	}



}
