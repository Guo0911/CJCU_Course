package Class09;

class R extends Thread implements Runnable{
	private int number;
	private int sleep_;
	
	public R(int n, int s) {
		number = n;
		sleep_ = s;
	}
	
	public void run() {
		for(int i = 0 ; i < 10 ; i++) {
			try {
				sleep(sleep_);
				System.out.println("Thread" + number + "is running");
			}
			catch(InterruptedException e){
			}
		}
	}
}

public class Class09 {
	public static void main(String [] args) {
		R r1 = new R(1,1000); //ans
		R r2 = new R(2,2500);
		
		Thread t1 = new Thread(r1); //ans
		Thread t2 = new Thread(r2);
		
		t1.start(); //ans
		t2.start();
	}
}

/*
Output:
Thread1is running
Thread1is running
Thread2is running
Thread1is running
Thread1is running
Thread2is running
Thread1is running
Thread1is running
Thread1is running
Thread2is running
Thread1is running
Thread1is running
Thread2is running
Thread1is running
Thread2is running
Thread2is running
Thread2is running
Thread2is running
Thread2is running
Thread2is running
*/