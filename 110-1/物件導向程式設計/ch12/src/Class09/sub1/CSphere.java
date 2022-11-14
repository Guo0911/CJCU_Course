package Class09.sub1;

public class CSphere { //9.(a)
	double radius;
	
	public CSphere(double r){ //9.(a)
		radius = r;
	}
	
	public void show() { //9.(b)
		System.out.println("radius = " + radius);
		System.out.println("volume = " + (Math.pow(radius, 3)*4/3.0*3.14));
	}
}
