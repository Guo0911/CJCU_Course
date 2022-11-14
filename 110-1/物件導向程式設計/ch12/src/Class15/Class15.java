package Class15;

public class Class15 {
	public static void main(String [] args) {
		float num = 123.45F;
		String str = String.valueOf(num); //ans
		System.out.println(str + " type is " + str.getClass().getSimpleName());
		System.out.println(str + " length is " + str.length()); //ans
	}
}

/*
Output:
123.45 type is String
123.45 length is 6
*/