package com.springbatch.steps;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class JobWriter  implements ItemWriter<String>{

	@Override
	public void write(List<? extends String> messages) throws Exception {
		System.out.println("Inside write of Item Writer with size " + messages.size());
		for(String message: messages) {
			System.out.println("Writing the data: " + message);
		}
		
	}

}
