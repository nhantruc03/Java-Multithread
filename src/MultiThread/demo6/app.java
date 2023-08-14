package MultiThread.demo6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{
	
	private int id;
	
	public Processor(int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}
	
	@Override
	public void run() {
		System.out.println("Starting process: " + id);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Completed process: " + id);
	}
	
}

public class app {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);	
		
		for(int i =0 ;i < 5; i++) {
			executor.submit(new Processor(i));
		}
		
		executor.shutdown();
		
		System.out.println("All submitted");
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
		}
		
		System.out.println("All done");
	}
		
}
