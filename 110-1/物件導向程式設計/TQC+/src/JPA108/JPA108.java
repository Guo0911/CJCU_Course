package JPA108;

class Test{
	private int Int1 ,Int2;
	private double Double1, Double2;
	private String String1, String2;
	
	public void add(int a, int b) {
		Int1 = a;
		Int2 = b;
	}
	
	public void add(double a, double b) {
		Double1 = a;
		Double2 = b;
	}
	
	public void add(String a, String b) {
		String1 = a;
		String2 = b;
	}
	
	public void show() {
		System.out.println((Int1+Int2) + " " + String.format("%.6f",Double1+Double2) + " " + (String1+String2));
	}
}

public class JPA108 {
	public static void main(String [] args) {
		Test a = new Test();
		a.add(2, 3);
		a.add(5.2, 4.3);
		a.add("I love ", "Java!!");
		a.show();
	}
}
