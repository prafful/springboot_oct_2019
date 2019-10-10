package com.springcore.beginner.mainapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.beginner.pojo.Blog;

public class InnerMainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BeanContext - is light weight
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		Blog blog = (Blog) ctx.getBean("blogBean");
		blog.setTitle("Introduction to Spring Core!");
		System.out.println(blog.getTitle());
		
		blog.displayGalleryInBlog();
		
	}

}
