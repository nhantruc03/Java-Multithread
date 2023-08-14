package MultiThread.demo3;

import java.util.Scanner;

class Process extends Thread{
	
	private volatile boolean running = true;
	
	@Override
	public void run() {
		while(running) {
	
			System.out.println("hello");
			
			try {
				Thread.sleep(100);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public void shutdown() {
		running = false;
	}
	
}

public class app {
	
	
	public static void main(String[] args) {
		Process proc1 = new Process();
		
		proc1.start();
		
		System.out.println("press any to return...");
		Scanner scanner = new Scanner(System.in);
		
		scanner.nextLine();
		
		proc1.shutdown();
		
	}

}
