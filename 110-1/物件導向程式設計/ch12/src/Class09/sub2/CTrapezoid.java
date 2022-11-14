package Class09.sub2;

public class CTrapezoid { //9.(c)
	int upper;
	int base;
	int height;
	
	public CTrapezoid(int u, int b, int h){ //9.(c)
		upper = u;
		base = b;
		height = h;
	}
	
	public void show() { //9.(d)
		System.out.println("upper  = " + upper);
		System.out.println("base   = " +  base);
		System.out.println("height = " + height);
		System.out.println("area   = " + (upper+base)*height/2.0);
	}
}
