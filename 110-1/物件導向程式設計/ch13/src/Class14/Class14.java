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
			System.out.println("�z��J����ƪ��ȤӤp");
			throw new IntegerTooSmall();
		}
		else if(num > 70) {//(b)
			System.out.println("�z��J����ƪ��ȤӤj");
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
			System.out.println("�z��J�����O���");
		}
	}
}

/*
Input1:
I am string.
Output1:
�z��J�����O���

Input2:
9
Output2:
�z��J����ƪ��ȤӤp

Input3:
71
Output3:
�z��J����ƪ��ȤӤj

Input4:
50
Output4:
50
*/