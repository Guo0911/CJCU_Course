package Java08;

public class CSphere {
	private int x;
	private int y;
	private int z;
	private int radius;
	
	void setLocation(int a , int b , int c) { //(a)
		this.x = a;
		this.y = b;
		this.z = c;
	}
	
	void setRadius(int r) { //(b)
		this.radius = r;
	}
	
	double surfaceArea() { //(c)
		return 4*3.14*radius*radius;
	}
	
	double volume() { //(d)
		return 3.14*radius*radius;
	}
	
	void showCenter() { //(e)
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		System.out.println("z = " + z);
	}
}
