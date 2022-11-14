package JPA102;

import java.util.Scanner;

public class JPA102 {
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please input:");
		double number = sc.nextDouble();
		
		String kg = String.format("%.6f", number);
		String ponds = String.format("%.6f", number*2.20462);
		
		System.out.println(kg + " kg = " + ponds + " ponds");
	}
}
