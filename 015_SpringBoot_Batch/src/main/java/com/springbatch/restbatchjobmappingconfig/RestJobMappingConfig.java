package com.springbatch.restbatchjobmappingconfig;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.jobcompletionlistener.JobCompletionListener;
import com.springbatch.steps.JobProcessor;
import com.springbatch.steps.JobReader;
import com.springbatch.steps.JobWriter;

@Configuration
public class RestJobMappingConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	//define the steps
	@Bean
	public Step startStep() {
		return stepBuilderFactory.get("takeStep1")
				.<String, String>chunk(1)
				.reader(new JobReader())
				.processor(new JobProcessor())
				.writer(new JobWriter()).build();
	}
	
	@Bean
	public Job startJob() {
		return jobBuilderFactory.get("processJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener())
				.flow(startStep()).end().build();
	}
	
	private JobCompletionListener listener() {
		return new JobCompletionListener();
	}
	
	
	
	
}
