package com.app.threads;

class ExampleThread extends Thread {
	public ExampleThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.printf("Thread %s index %d \n", this.getName(), i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class BuildThread {
	public static void main(String[] args) {
		ExampleThread thread1 = new ExampleThread("Thread 1");
		ExampleThread thread2 = new ExampleThread("Thread 2");
		
		thread1.start();
		thread2.start();
	}
}
