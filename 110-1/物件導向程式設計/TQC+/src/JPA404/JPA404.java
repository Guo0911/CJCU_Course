package JPA404;

import java.util.Scanner;

public class JPA404 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Input m：");
		int m = sc.nextInt();
		
		while(m != 999) {
			System.out.print("Input n：");
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
			System.out.println("最大公因數為：" + max);
			
			System.out.print("Input m：");
			m = sc.nextInt();
		}
	}
}
