package com.springmvc.form.pojo;

public class Friend {
	
	private int id;
	private String name;
	private String location;
	private int years;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	public Friend(int id, String name, String location, int years) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.years = years;
	}
	public Friend() {
		super();
	}
	
	
	
	
	

}
