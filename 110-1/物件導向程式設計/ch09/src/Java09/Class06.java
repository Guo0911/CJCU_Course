package Java09;

public class Class06 {
	public static void add2n (int n){
		int ans = 0 ;
		for(int i = 1 ; i <= n ; i++) {
			ans += i ;
			if (i == 5 || i == 10){
				System.out.println(ans);
			}
		}
		System.out.println(ans);
	}
	
	public static void main(String[]args) {
		add2n(10);
	}
}
