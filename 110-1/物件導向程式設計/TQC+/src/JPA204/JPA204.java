package JPA204;

import java.util.Scanner;

public class JPA204 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i <2 ; i++) {
			System.out.println("input : ");
			
			int number = sc.nextInt();
			
			if(number % 5 == 0 && number % 9 == 0) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}
	}
}
