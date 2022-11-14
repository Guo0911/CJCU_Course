package Class04;

class CTest extends Thread{
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

public class Class04 {
	public static void main(String [] args) {
		CTest hi = new CTest("Hello");
		CTest bye = new CTest("Good bye");
		CTest morning = new CTest("Good morning"); //ans

		hi.start();
		bye.start();
		morning.start(); //ans
	}
}

/*
Output:
Good bye 1
Good morning 1
Hello 1
Good morning 2
Good morning 3
Good morning 4
Good morning 5
Good bye 2
Hello 2
Good bye 3
Hello 3
Good bye 4
Hello 4
Hello 5
Good bye 5
*/