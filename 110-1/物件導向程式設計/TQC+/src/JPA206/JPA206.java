package JPA206;

import java.util.Scanner;

public class JPA206 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < 4 ; i++) {
			System.out.print("Input Chinese score¡G");
			int chinese = sc.nextInt();
			
			System.out.print("Input English score¡G");
			int english = sc.nextInt();
			
			System.out.print("Input Math score¡G");
			int math = sc.nextInt();
			
			if(chinese >= 60 && english >= 60 && math >= 60) {
				System.out.println("All pass");
			}
			else {
				if(chinese < 60) {
					System.out.println("Chinese failed.");
				}
				if(english < 60) {
					System.out.println("English failed.");
				}
				if(math < 60) {
					System.out.println("Math failed.");
				}
			}
		}
	}
}
