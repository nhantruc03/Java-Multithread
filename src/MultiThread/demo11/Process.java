package MultiThread.demo11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Process {
	
	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
	
	
	private void increment() {
		for(int i = 0 ; i<100000;i++) {
			count++;
		}
	}
	
	public void firtstThread() throws InterruptedException {
		lock.lock();
		System.out.println("Waiting....");
		cond.await();
		System.out.println("Woken up");
		
		
		try {
			increment();
		}finally {
			// TODO: handle exception
			lock.unlock();
		}
		
	}
	
	public void secondThread() throws InterruptedException {
		
		Thread.sleep(1000);
		lock.lock();
		
		System.out.println("Press return key!");
		new Scanner(System.in).nextLine();
		System.out.println("Got return key!");
		cond.signal();
		
		try {
			increment();
		}finally {
			// TODO: handle exception
			lock.unlock();
		}
		
	}
	
	public void finish() {
		System.out.println("Final count: "+ count);
	}

}
;