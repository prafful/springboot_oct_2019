package com.springcore.beginner.pojo;

public class Blog {
	
	private String title;
	private Gallery gallery;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Gallery getGallery() {
		return gallery;
	}
	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}
	
	public void displayGalleryInBlog() {
		System.out.println("In Blog Class display method");
		gallery.displayGallery();
		System.out.println("1___________________________________");
	}
	
	

}
