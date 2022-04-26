package com.app.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class People {
	private String name;
	private int age;
	
	public People() {}
	
	public People (String name) {
		this.name = name;
	}
	
	public People(String name, int age) {
		this(name);
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "People = { Name: " + name + ", Age: " + age + " }";
	}
}

public class TestStream {
	public static void main(String[] args) {
		List<People> peoples = Arrays.asList(new People("Andr�s", 10), new People("Oscar", 30), new People("Jorledis", 25), new People("Alejandra", 18), new People("Martin", 52));
		List<People> newList = peoples.stream().filter(p -> p.getAge() >= 18).limit(3).collect(Collectors.toList());
		System.out.println(newList);
	}
}
