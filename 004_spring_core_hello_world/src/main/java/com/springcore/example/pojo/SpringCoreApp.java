package com.springcore.example.pojo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCoreApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("settings.xml");
		
		FriendPojo fp = (FriendPojo) context.getBean("friendBean");
		
		//fp.setLocation("Bengaluru");
		
		System.out.println(fp.getLocation());
		
		
		
	}

}
