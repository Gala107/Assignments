package com;

//class PrintingTask extends Thread{
class PrintingTask extends Thread{
	
	public void run() {
		for (int i =1; i<=10; i++) {
			System.out.println("[PrintingTask] Printing Book Pages for LearningPython.pdf: Page#: " + i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class MultiThreading {

	public static void main(String[] args) {
		System.out.println("[main] Thread Started");
		
		// start method on Thread internally executes run();
//		PrintingTask task = new PrintingTask();
//		task.start();
		
		Thread thread = new Thread(new PrintingTask());
		thread.setPriority(Thread.MAX_PRIORITY);
		thread.start();
		
		for (int i =1; i<=10; i++) {
			System.out.println("[main] Printing Book Pages for LearningJava.pdf: Page#: " + i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println();
		System.out.println("child thread name is " + thread.getName() + " priority is: " + thread.getPriority());
		System.out.println("main thread name is " + Thread.currentThread().getName() + " priority is: " + Thread.currentThread().getPriority());
		System.out.println("Main Thread Finished");
	}
}
