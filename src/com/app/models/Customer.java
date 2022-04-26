package com.app.models;

public class Customer implements Comparable<Customer> {
	private String name;
	private int note;
	
	public Customer() {}
	
	public Customer(String name, int note) {
		this.name = name;
		this.note = note;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNote() {
		return note;
	}
	
	public void setNote(int note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Customer = { Name: " + name + ", Note: " + note + " }";
	}

	@Override
	public int compareTo(Customer o) {
		/*if (this.name == null) return 0;
		return this.name.compareTo(o.getName());*/
		
		if (this.note == o.note) return 0;
		return (this.note > o.note) ? 1 : -1;
	}
}















