package Class15;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class ArgumentOutOfBound extends Exception{
}

public class Class15 {
	
	public static void mySqrt(double n) throws ArgumentOutOfBound{ //ans
		if(n < 0) {
			System.out.println("n小於0");
			throw new ArgumentOutOfBound();
		}
		else {
			System.out.println(Math.pow(n, 0.5));
		}
	}

	public static void main(String [] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String a = br.readLine();
			double n = Double.parseDouble(a);
			mySqrt(n);
		}
		catch(Exception e){
		}
	}
}

/*
Input1:
0.1
Output1:
0.31622776601683794

Input2:
81
Output2:
9.0

Input2:
-0.0001
Output2:
n小於0
*/