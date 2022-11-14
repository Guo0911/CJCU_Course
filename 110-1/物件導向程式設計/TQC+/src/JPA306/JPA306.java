package JPA306;

import java.util.Scanner;

public class JPA306 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input¡G");
		String[] a = sc.nextLine().split(" ");
		int m = Integer.parseInt(a[0]);
		int n = Integer.parseInt(a[1]);
		
		
		while(m != 999) {
			System.out.println((long)Math.pow(m, n));
			
			System.out.println("Input¡G");
			a = sc.nextLine().split(" ");
			m = Integer.parseInt(a[0]);
			n = Integer.parseInt(a[1]);
		}
	}
}
