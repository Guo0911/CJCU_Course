package Class14;

class PrePaid extends Thread{ //(a)
	int sum = 200;
	
	public void talk(int f) {
		try {
			sleep((int)(Math.random()*1000)); //(c)
			sum -= f;
		}
		catch(InterruptedException e) {
		}
		System.out.println("the sum is " + sum);
	}
	
	public void run() { //(b)
		while(sum > 10) {
			int fee = (int)(Math.random()*100);
			talk(fee);
		}
	}
}

public class Class14 {
	public static void main(String [] args) {
		PrePaid p = new PrePaid();
		
		p.start();
	}
}

/*
Output:
the sum is 108
the sum is 59
the sum is -18
*/