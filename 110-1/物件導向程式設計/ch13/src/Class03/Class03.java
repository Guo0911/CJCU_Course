package Class03;

public class Class03 {
	public static void main(String [] args) {
		int num = 12, den = 0;
		
		try{ //ans
			int ans = num / den;
		}
		catch(ArithmeticException e) { //ans
			System.out.println("���Ƭ�0");
		}
		finally {
			System.out.println("end of main() !!");
		}
	}
}

/*
Output:
���Ƭ�0
end of main() !!
*/