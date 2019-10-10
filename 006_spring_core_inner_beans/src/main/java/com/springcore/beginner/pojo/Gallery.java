package com.springcore.beginner.pojo;

public class Gallery {
	
	private String title;
	private Picture picture;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}
	
	public void displayGallery() {
		System.out.println("In Gallery Class display method");
		System.out.println("Gallery Displayed. Use Picture Display method!");
		picture.displayPicture();
		System.out.println("2______________________________________________");
	}
	

}
