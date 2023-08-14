package MultiThread.demo10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Process {
	
	private List<Integer> list = new ArrayList<Integer>();
	private final int LIMIT = 10;
	private Object lock = new Object();
	
	public void produce() throws InterruptedException {
		int value = 0;
		while(true) {
			
			synchronized (lock) {
				
				while(list.size() == LIMIT) {
					lock.wait();
				}
				
				list.add(value++);
				lock.notify();
			}
			
		}
		
	}
	
	public void consume() throws InterruptedException {
		
		Random ran = new Random();
		
		while(true) {
			synchronized(lock) {
				
				while(list.size()==0) {
					lock.wait();
				}
				
				System.out.print("List size: "+ list.size());
				int value = list.remove(0);
				System.out.println("; value is: "+ value);	
				lock.notify();
			}
			Thread.sleep(ran.nextInt(1000));
		}
	}

}
;