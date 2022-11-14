package JPA310;

import java.util.Scanner;

public class JPA310 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0, n;
		do{
			System.out.print("請輸入n的值(n > 0，且為偶數：");
			n = sc.nextInt();
		}while(n % 2 != 0 || n <= 0);
		
		int now = 0;
		
		do {
			now += 2;
			sum += now;
		}while(now != n);
		
		if(n == 2) {
			System.out.println("2=" + sum);
		}
		else if(n == 2) {
			System.out.println("2+4=" + sum);
		}
		else{
			System.out.println("2+4+...+" + n + "=" + sum);
		}
	}
}
