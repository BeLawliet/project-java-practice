package com.app.models;

public class User {
	private String name;
	private String lastName;
	private Integer id;
	private static int lastId;
	
	public User() {
		this.id = ++lastId;
	}
	
	public User(String name, String lastName) {
		this();
		this.name = name;
		this.lastName = lastName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User = { Id: " + id +  ", Name: " + name + ", Last Name: " + lastName + " }";
	}
}
