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
				System.out.println("������ҥ~�F");
			}
		}
	}
}

/*
Output:
ans = 1
������ҥ~�F
ans = 4
������ҥ~�F
������ҥ~�F
ans = 3
������ҥ~�F
������ҥ~�F
������ҥ~�F
������ҥ~�F
*/