package com.springmvc.hibernateapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "friend_table")
public class FriendEntity {
	
	@Id
	@Column(name = "friend_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "friend_name")
	private String name;
	@Column(name = "friend_location")
	private String location;
	@Column(name = "friend_years")
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
	
	public FriendEntity(int id, String name, String location, int years) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.years = years;
	}
	
	public FriendEntity() {
		super();
		
	}
	
	

}
