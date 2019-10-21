package com.springboot.rest.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springboot.rest.restcontroller"})
public class MainRestEntryPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(MainRestEntryPoint.class, args);
	}

}
