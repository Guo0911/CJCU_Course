package Class13;

import java.util.Scanner;

class Exception520 extends Exception{
}

public class Class13 {
	public static void check(int num) throws Exception520{
		if(num == 520) { //ans
			System.out.println("這是由字串 520 所引起的例外");
			throw new Exception520();
		}
	}
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		try {
			int num = Integer.parseInt(input);
			try {
				check(num);
				System.out.println(input);  //ans
			}
			catch(Exception e) {
			}
		}
		catch(Exception e){ //ans
			System.out.println(input);
		}
	}
}

/*
input1:
520
Output1:
這是由字串 520 所引起的例外

input2:
111
Output2:
111

input3:
I am string.
Output3:
I am string.
*/