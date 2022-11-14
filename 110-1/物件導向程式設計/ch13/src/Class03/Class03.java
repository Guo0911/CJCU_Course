package Class03;

public class Class03 {
	public static void main(String [] args) {
		int num = 12, den = 0;
		
		try{ //ans
			int ans = num / den;
		}
		catch(ArithmeticException e) { //ans
			System.out.println("除數為0");
		}
		finally {
			System.out.println("end of main() !!");
		}
	}
}

/*
Output:
除數為0
end of main() !!
*/