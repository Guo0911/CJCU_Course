package Class12;

class NotTriangle extends Exception{
}

class EquilateralTriangle extends Exception{
}

class NotEquilateralTriangle extends Exception{
}

class triangle{
	public void triangle(int a, int b, int c) throws NotTriangle, EquilateralTriangle, NotEquilateralTriangle {
		if((a+b) < c || (a+c) < b || (b+c) < a ) { //(a)
			System.out.println("不構成三角形");
			throw new NotTriangle();
		}
		else if(a==b && b==c && a==c) { //(b)
			System.out.println("這是正三角形");
			throw new EquilateralTriangle();
		}
		else { //(c)
			System.out.println("這不是正三角形");
			throw new NotEquilateralTriangle();
		}
	}
}

public class Class12 {
	public static void main(String [] args) {
		int a = 3, b = 3, c = 3;
		triangle t = new triangle();
		
		try {
			t.triangle(a,b,c);
		}
		catch(Exception e) {
			System.out.println(e + " throwed");
		}
	}
}

/*
Output:
這是正三角形
Class12.EquilateralTriangle throwed
*/
