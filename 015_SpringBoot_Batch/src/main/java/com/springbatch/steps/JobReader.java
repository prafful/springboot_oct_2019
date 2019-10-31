package com.springbatch.steps;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class JobReader implements ItemReader<String> {

	private String[] messages = {
			"Spring Batch",
			"First Program",
			"using H2 for configuration",
			"Fun with steps!",
			"Spring Batch",
			"First Program",
			"using H2 for configuration",
			"Fun with steps!","Spring Batch",
			"First Program",
			"using H2 for configuration",
			"Fun with steps!","Spring Batch",
			"First Program",
			"using H2 for configuration",
			"Fun with steps!","Spring Batch",
			"First Program",
			"using H2 for configuration",
			"Fun with steps!",
			"Spring Batch",
			"First Program",
			"using H2 for configuration",
			"Fun with steps!",
			"Spring Batch",
			"First Program",
			"using H2 for configuration",
			"Fun with steps!","Spring Batch",
			"First Program",
			"using H2 for configuration",
			"Fun with steps!","Spring Batch",
			"First Program",
			"using H2 for configuration",
			"Fun with steps!","Spring Batch",
			"First Program",
			"using H2 for configuration",
			"Fun with steps!","Spring Batch",
			"First Program",
			"using H2 for configuration",
			"Fun with steps!",
			"Spring Batch",
			"First Program",
			"using H2 for configuration",
			"Fun with steps!","Spring Batch",
			"First Program",
			"using H2 for configuration",
			"Fun with steps!","Spring Batch",
			"First Program",
			"using H2 for configuration",
			"Fun with steps!","Spring Batch",
			"First Program",
			"using H2 for configuration",
			"Fun with steps!",
			"Spring Batch",
			"First Program",
			"using H2 for configuration",
			"Fun with steps!",
			"Spring Batch",
			"First Program",
			"using H2 for configuration",
			"Fun with steps!","Spring Batch",
			"First Program",
			"using H2 for configuration",
			"Fun with steps!","Spring Batch",
			"First Program",
			"using H2 for configuration",
			"Fun with steps!","Spring Batch",
			"First Program",
			"using H2 for configuration",
			"Fun with steps!"
	};
	
	private int count = 0;
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		if(count < messages.length) {
			System.out.println("Inside read of Item Reader");
			return messages[count++];
		}else {
			count = 0;
		}
		
		return null;
	}

}
