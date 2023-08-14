package MultiThread.demo1;



class Runner extends Thread{
	
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

public class Demo1 {
	public static void main(String[] args) {
		Runner runner = new Runner();
		runner.start();
		
		Runner runner2 = new Runner();
		runner2.start();
	}
}
