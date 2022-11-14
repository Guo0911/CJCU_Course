package Class02;

class CTest extends Thread{ //(a)
	private String id;
	
	public  CTest(String str) { //(a)
		id = str;
	}
	
	public void run() { //(b)
		for(int i = 1 ; i <= 5 ; i++) {
			for(int j = 0 ; j < 100000000 ; j++);
			System.out.println(id + " " + i);
		}
	}
}

public class Class02 {
	public static void main(String [] args) { //(c)
		CTest hi = new CTest("Hello");
		CTest bye = new CTest("Good bye");

		hi.run();
		bye.run();
	}
}

/*
(d) The program will run the object bye after the object hi ends. So this program will first output Hello 1 to Hello 5 before Good bye.

Output:
Hello 1
Hello 2
Hello 3
Hello 4
Hello 5
Good bye 1
Good bye 2
Good bye 3
Good bye 4
Good bye 5
*/