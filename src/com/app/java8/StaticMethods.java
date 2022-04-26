package com.app.java8;

interface Follower {
	default void follow() {
		System.out.println("This is a generic method for the interface");
	}
	
	static void print() {
		System.out.println("This is a static method in a interface");
	}
}

public class StaticMethods {
	public static void main(String[] args) {
		Follower.print();
	}
}
