package Class07;

public class Class07 {
	
	public static void test(int num, int den) { //ans
		System.out.println("ans = " + num / den);
	}
	
	public static void main(String [] args) {
		
		try {
			test(12,0);
		}
		catch(ArithmeticException e) {
			System.out.println("������ҥ~�F");
		}
		
		System.out.println("end of main() !!");
	}
}

/*
Output:
������ҥ~�F
end of main() !!
*/