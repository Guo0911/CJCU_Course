package JPA404;

import java.util.Scanner;

public class JPA404 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Input m�G");
		int m = sc.nextInt();
		
		while(m != 999) {
			System.out.print("Input n�G");
			int n = sc.nextInt();
			
			int max = 1;
			int min = m;
			
			if(min > n) {
				min = n;
			}
			
			for(int i = 2 ; i <= min ; i++) {
				if(m % i == 0 && n % i == 0) {
					max = i;
				}
			}
			System.out.println("�̤j���]�Ƭ��G" + max);
			
			System.out.print("Input m�G");
			m = sc.nextInt();
		}
	}
}
