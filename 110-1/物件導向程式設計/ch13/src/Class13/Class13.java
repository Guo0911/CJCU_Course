package Class13;

import java.util.Scanner;

class Exception520 extends Exception{
}

public class Class13 {
	public static void check(int num) throws Exception520{
		if(num == 520) { //ans
			System.out.println("�o�O�Ѧr�� 520 �Ҥް_���ҥ~");
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
�o�O�Ѧr�� 520 �Ҥް_���ҥ~

input2:
111
Output2:
111

input3:
I am string.
Output3:
I am string.
*/