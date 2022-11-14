package JPA402;

import java.util.Scanner;

public class JPA402 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Input n (0 <= n <= 16¡G");
		int n = sc.nextInt();
		
		while(n != 999) {
			System.out.println(n + "¡@ªº¶¥¼h(§À¬q»¼°j) = " + test(n));
			
			int sum = 1;
			for(int i = 1 ; i <= n ; i++) {
				sum *= i;
			}
			System.out.println(n + "¡@ªº¶¥¼h(°j°é) = " + sum);

			System.out.print("Input n (0 <= n <= 16¡G");
			n = sc.nextInt();
		}
	}
	
	static int test(int x){
		if(x == 1) {
			return 1;
		}
		else {
			return x * test(x-1);
		}
	}
}
