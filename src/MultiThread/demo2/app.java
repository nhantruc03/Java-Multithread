package MultiThread.demo2;



class Runner implements Runnable {
	
	@Override
	public void run() {
		for(int i =0;i <= 5; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}

public class app {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runner());
		thread1.start();
		Thread thread2 = new Thread(new Runner());
		thread2.start();
		
	}
}
