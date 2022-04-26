package com.app.threads;

class ExampleRunnable implements Runnable {
	private int value;
	
	public ExampleRunnable(int value) {
		this.value = value;
	}
	
	@Override
	public void run() {
		System.out.printf("State %s \n", Thread.currentThread().getState());
		
		for (int i = value; i >= 0; i--) {
			System.out.printf("%s Value %d \n", Thread.currentThread().getName(), i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class BuildRunnable {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new ExampleRunnable(10), "Wow");
		System.out.printf("State %s \n", thread.getState());
		thread.start();
		
		thread.join();
		System.out.printf("State %s \n", thread.getState());
		
		/*
		Thread thread2 = new Thread(new ExampleRunnable(5), "Jajaja");
		thread2.start();
		System.out.println("Se lanzarón los hilos");
		
		thread.join();
		thread2.join();
		
		System.out.println("FINAL APP");
		*/
	}
}
