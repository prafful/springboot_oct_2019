package com.example.springbatch.steps;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.example.springbatch.pojo.User;

public class CSVUserReader implements ItemReader<User> {

	@Override
	public User read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		
		
		
		
		return null;
		
	}

	
}
