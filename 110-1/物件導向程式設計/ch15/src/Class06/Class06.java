package Class06;

class Add implements Runnable{ //ans
	private int n;
	private int sum = 0;
	
	public Add(int a) {
		n = a;
	}
	
	public void run() { //ans
		for(int i = 1 ; i <= n ; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}

public class Class06 {
	public static void main(String [] args) {
		Add add = new Add(10);
		Thread t1 = new Thread(add); //ans
		t1.start();
	}
}

/*
Output:
55
*/