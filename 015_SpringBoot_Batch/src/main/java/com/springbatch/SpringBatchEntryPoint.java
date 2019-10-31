package com.springbatch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchEntryPoint {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchEntryPoint.class, args);
	}

}
