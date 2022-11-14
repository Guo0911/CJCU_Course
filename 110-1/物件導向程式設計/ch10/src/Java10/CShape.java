package Java10;

class CShape {
	public double area() {
		return 0.0;
	}
	
	public static void largest(CCircle obj1 , CCircle obj2 , CSquare obj3 , CSquare obj4 , CSTrangle obj5 , CSTrangle obj6) 
	{ //(11).e -> yes.
		double[] area = new double[6];
		area[0] = obj1.area();
		area[1] = obj2.area();
		area[2] = obj3.area();
		area[3] = obj4.area();
		area[4] = obj5.area();
		area[5] = obj6.area();
		
		double max = 0;
		
		for(double i : area) {
			if(i > max){
				max = i;
			}
		}
		
		System.out.println("Max area = " + max);
	}
}

class CCircle extends CShape{ //(11).a
	private double pi = 3.14;
	private double radius;
	
	public CCircle(double r) {
		radius = r;
	}
	
	public double area() {
		return pi*radius*radius;
	}
}

class CSquare extends CShape{ //(11).b
	private double side;
	
	public CSquare(double s) {
		side = s;
	}
	
	public double area() {
		return side*side;
	}
}

class CSTrangle extends CShape{ //(11).c
	private double base;
	private double height;
	
	public CSTrangle(double b,double h) {
		base = b;
		height = h;
	}
	
	public double area() {
		return base*height/2;
	}
}


