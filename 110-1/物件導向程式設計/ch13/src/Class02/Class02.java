package Class02;

public class Class02 {
	public static void main(String [] args) {
		int num = 12, den = 0;
		
		if(den == 0) { //ans
			System.out.println("除數為0");
		}
		else {
			int ans = num / den;
			System.out.println("ans = " + ans);
		}
		
		System.out.println("end of main() !!");
	}
}

/*
Output:
除數為0
end of main() !!
*/