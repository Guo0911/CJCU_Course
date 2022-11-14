package Class03;

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

public class Class03 {
	public static void main(String [] args) {
		CTest hi = new CTest("Hello");
		CTest bye = new CTest("Good bye");

		hi.start(); //ans
		bye.start(); //ans
	}
}

/*
Output:
Good bye 1
Hello 1
Hello 2
Good bye 2
Good bye 3
Hello 3
Hello 4
Good bye 4
Good bye 5
Hello 5
*/