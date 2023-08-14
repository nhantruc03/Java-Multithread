package MultiThread.demo9;

import java.util.Scanner;

public class Process {
	
	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("Start produce");
			
			wait();
			
			System.out.println("Returned produce");
			
		}
		
	}
	
	public void consume() throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		Thread.sleep(2000);
		synchronized (this) {
			System.out.println("Start consume");
			sc.nextLine();
			
			notify();
			
			System.out.println("Done consume");
		}
		
	}

}
