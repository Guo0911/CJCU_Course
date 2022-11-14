package Class16;

public class Class16 {
	public static void main(String [] args) {
		String str = "262904713";
		int num = Integer.valueOf(str);
		System.out.println(num + " type is " + ((Object)num).getClass().getSimpleName());
		System.out.println("Double " + num + " is " + num*2);
	}
}

/*
Output:
262904713 type is Integer
Double 262904713 is 525809426
*/