package Class07;

class CTest implements Runnable{ //ans
	private String id;
	public  CTest(String str) {
		id = str;
	}
	
	public void run() {
		for(int i = 1 ; i <= 5 ; i++) {
			for(int j = 0 ; j < 100000000 ; j++);
			System.out.println(id + " " + i);
		}
	}
}

public class Class07 {
	public static void main(String [] args) {
		CTest hi = new CTest("Hello");
		CTest bye = new CTest("Good bye");
		CTest morning = new CTest("Good morning");

		Thread t1 = new Thread(hi); //ans
		Thread t2 = new Thread(bye);
		Thread t3 = new Thread(morning);
		
		t1.start(); //ans
		t2.start();
		t3.start();
	}
}

/*
Output:
Hello 1
Good morning 1
Good bye 1
Good morning 2
Hello 2
Hello 3
Good bye 2
Good bye 3
Good bye 4
Good bye 5
Hello 4
Good morning 3
Hello 5
Good morning 4
Good morning 5
*/