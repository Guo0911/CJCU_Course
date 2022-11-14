package Class03;

import java.util.Scanner;

public class Class03 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		int sum = 0;
		
		for(int i = 1 ; i <= input ; i++) { //ans
			sum += i;
		}
		
		System.out.println("1 to " + input + " sum is " + sum);
	}
}

/*
Input:
10
Output:
1 to 10 sum is 55
*/