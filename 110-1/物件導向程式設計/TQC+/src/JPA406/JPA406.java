package JPA406;

import java.util.Scanner;

public class JPA406 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 0 ; t < 2 ; t++) {
			System.out.print("Input a string¡G");
			String a = sc.nextLine();
			String[] A = a.split("");
			
			int times = 0;
			
			for(int i = 0 ; i < A.length ; i++) {
				if(A[i].equals("A")){
					times++;
				}
			}
			System.out.println(a + " has " + times + " As");
		}
	}
}
