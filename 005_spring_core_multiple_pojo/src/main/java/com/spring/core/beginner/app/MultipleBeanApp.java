package com.spring.core.beginner.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.beginner.pojo.Friend;
import com.spring.core.beginner.pojo.Location;

public class MultipleBeanApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Friend f = (Friend) context.getBean("friendBean");
		Location l = (Location) context.getBean("locationBean");
		f.setName("Manoj");
		
		System.out.println(f.getName() + " from " + l.getLocation());
		
		f.printName();
		
		Friend f2 = (Friend) context.getBean("friendBean");
		System.out.println(f2.getName() );
		
		Friend f3 = (Friend) context.getBean("friendBean");
		System.out.println(f3.getName() );
		
		

	}

}
