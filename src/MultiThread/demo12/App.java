package MultiThread.demo12;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class App {

	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService excutor = Executors.newCachedThreadPool();
		
		Future<Integer> future = excutor.submit(new Callable<Integer>() {
			
			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				Random ran = new Random();
				
				int duration = ran.nextInt(4000);
				
				
//				if(duration>10) {
//					throw new IOException("Sleeping for too long");
//				}
				
				
				for(int i = 0 ; i< 1E8;i++) {
					
					if(Thread.currentThread().isInterrupted()) {
						System.out.println("Interrupted!");
						break;
					}
					Math.sin(ran.nextDouble());
				}
				
//				try {
//					Thread.sleep(duration);					
//				}catch (InterruptedException e) {
//					// TODO: handle exception
//					e.printStackTrace();
//				}
				
//				System.out.println("Done");
				return duration;
			}
		});
		
		excutor.shutdown();
		
		Thread.sleep(3000);
		
//		excutor.shutdownNow();
		future.cancel(true);
		
		excutor.awaitTermination(1, TimeUnit.DAYS);
		
		System.out.println("Finished");
		
//		try {
//			System.out.println("Result: " + future.get());
//		}catch (InterruptedException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}catch (ExecutionException e) {
//			// TODO: handle exception
//			System.out.println(e);
//			
//			System.out.println(e.getMessage());
//			
//			System.out.println(e.getCause().getMessage());
//		}
	}
}
