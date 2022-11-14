package Quiz01;

import java.util.Scanner;
public class Class02 {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input a number:");
		int a = sc.nextInt();
		is_prime(a);
	}
	public static void is_prime(int num) {
		boolean check = false;
		for(int i = 2 ; i <= num/2 ; i++) {
			if (num % i == 0) {
				check = true;
				break;
			}
		}
		if (check == true) {
			System.out.println("NO");
		}
		else {
			System.out.println("YES");
		}
	}
}
/*
input:
Input a number:37
YES

Input a number:39
NO
*/