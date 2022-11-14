package Class17;

public class Class17 {
	public static void main(String [] args) {
		String str = "262904713";
		short num = Short.valueOf(str);
		System.out.println(num + " type is " + ((Object)num).getClass().getSimpleName());
		System.out.println("Double " + num + " is " + num*2);
	}
}

// 262904713 out range of short type
