package com.app.java8;

interface Follower {
	// Se pueden sobreescribir
	default void follow() {
		System.out.println("This is a generic method for the interface");
	}
	
	static void print() {
		System.out.println("This is a static method in a interface");
	}
}

class FollowerImpl implements Follower {
	@Override
	public void follow() {
		System.out.println("This is a follower implementation");
	}
}

public class StaticMethods {
	public static void main(String[] args) {
		Follower.print();

		FollowerImpl followerImpl = new FollowerImpl();
		followerImpl.follow();
	}
}
