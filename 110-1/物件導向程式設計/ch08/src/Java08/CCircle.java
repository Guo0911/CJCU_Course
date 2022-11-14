package Java08;

public class CCircle {
	double pi=3.14;
	double radius;
	
	void show_periphery() {
		System.out.println("periphery = " + (2*pi*radius));
	}
	
	double area(double r) { //13-(a)
		this.radius = r;
		return pi*radius*radius;
	}
	
	float area(float r) { //13-(b)
		this.radius = r;
		return (float)(pi*radius*radius);
	}
	
	int area(int r) { //13-(c)
		this.radius = r;
		return (int)(pi*radius*radius);
	}
	
}
