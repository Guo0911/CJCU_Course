package Class06;

public class Class06 {
	public static void main(String [] args) {
		int num = 12;
		int den[] = {12,0,3,0,0,4};
		
		for(int i = 0; i < 10; i++) {
			try {
				System.out.println("ans = " + num/den[i]);
			}
			catch(Exception e) { //ans
				System.out.println("捕捉到例外了");
			}
		}
	}
}

/*
Output:
ans = 1
捕捉到例外了
ans = 4
捕捉到例外了
捕捉到例外了
ans = 3
捕捉到例外了
捕捉到例外了
捕捉到例外了
捕捉到例外了
*/