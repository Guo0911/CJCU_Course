package JPA208;

import java.util.Scanner;

public class JPA208 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < 5 ; i++) {
			System.out.println("Input¡G");
			int number = sc.nextInt();
			
			if(number >= 90) System.out.println("Your grade is A");
			else if(number >= 80) System.out.println("Your grade is B");
			else if(number >= 70) System.out.println("Your grade is C");
			else if(number >= 60) System.out.println("Your grade is D");
			else System.out.println("Your grade is F");
		}
	}
}
