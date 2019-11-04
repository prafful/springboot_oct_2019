package com.example.demo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBatchEntry {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchEntry.class, args);
	}

}
