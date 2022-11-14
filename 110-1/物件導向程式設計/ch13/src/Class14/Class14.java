package Class14;

import java.util.InputMismatchException;
import java.util.Scanner;

class IntegerTooSmall extends Exception{
}

class IntegerTooLarge extends Exception{
}

public class Class14 {
	public static void check(int num) throws IntegerTooSmall, IntegerTooLarge{
		if(num < 10) { //(a)
			System.out.println("您輸入的整數的值太小");
			throw new IntegerTooSmall();
		}
		else if(num > 70) {//(b)
			System.out.println("您輸入的整數的值太大");
			throw new IntegerTooLarge();
		}
		else { //(c)
			System.out.println(num);
		}
	}
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			int num = sc.nextInt();
			try {
				check(num);
			}
			catch(Exception e) {
			}
		}
		catch(InputMismatchException e){ //(d)
			System.out.println("您輸入的不是整數");
		}
	}
}

/*
Input1:
I am string.
Output1:
您輸入的不是整數

Input2:
9
Output2:
您輸入的整數的值太小

Input3:
71
Output3:
您輸入的整數的值太大

Input4:
50
Output4:
50
*/