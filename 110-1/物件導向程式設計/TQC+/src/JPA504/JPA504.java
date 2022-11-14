package JPA504;

public class JPA504 {
	public static void main(String [] args) {
		int[] num = new int[10];
		
		num[0] = 0;
		num[1] = 1;
		
		for(int i = 2 ; i < 10 ; i++) {
			num[i] = num[i-1] + num[i-2];
		}
		for(int i = 0 ; i < 10 ; i++) {
			System.out.println(num[i]);
		}
	}
}
