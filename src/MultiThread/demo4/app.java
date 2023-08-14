package MultiThread.demo4;

public class app {
	
	private int count = 0 ;

	public static void main(String[] args) {

		app a = new app();
		a.doWork();
		
	}
	
	public synchronized void plus() {
		count++;
	}
	
	public void doWork() {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i =0 ; i < 1000; i++) {
					plus();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i =0 ; i < 1000; i++) {
					plus();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(count);
	}
	
}
