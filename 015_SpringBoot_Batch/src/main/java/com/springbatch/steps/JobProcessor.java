package com.springbatch.steps;

import org.springframework.batch.item.ItemProcessor;

public class JobProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String message) throws Exception {
		System.out.println("Inside process of Item Processor");
		// TODO Auto-generated method stub
		return message.toUpperCase();
	}
	

	
}
