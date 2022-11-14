package Quiz01;

class Cal{
	private double pi = 3.14159;
	
	void Cal_area(int r) {
		System.out.println("圓的體積 = " + ((4.0/3.0)*pi*(Math.pow(r, 3))));
	}
	
	void Cal_area(int l, int w, int h) {
		System.out.println("立方體的表面積 = " + ((l*w*2) + (l*h*2) + (w*h*2)));
	}
}

public class Class01 {
	public static void main(String[]args) {
		Cal a = new Cal();
		a.Cal_area(10);
		a.Cal_area(4,5,6);
	}
}

/*
print:
圓的體積 = 4188.786666666666
立方體的表面積 = 148
*/