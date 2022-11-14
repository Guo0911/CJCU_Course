package Class09;

interface Math{
	public void show();
	
	public void add(int a, int b);
	
	public void sub(int a, int b);
	
	public void mul(int a, int b);
	
	public void div(int a, int b);
}

interface AdvancedMath{
	public void mod (int a, int b);
	
	public void fac (int a);
	
	public void pow (int a, int b);
}

class Compute implements Math,AdvancedMath{  //ans
	
	protected int ans;
	
	public void show() {
		System.out.println("ans = " + ans);
	}
	
	public void add(int a, int b) {
		ans = a+b;
	}

	public void sub(int a, int b) {
		ans = a-b;
	}

	public void mul(int a, int b) {
		ans = a*b;
	}

	public void div(int a, int b) {
		ans = a/b;
	}

	public void mod (int a, int b) { //ans
		ans = a%b;
	}
	
	public void fac (int a) { //ans
		ans = 1;
		for(int i = 1 ; i <= a ; i++) {
			ans *= i;
		}
	}
	
	public void pow (int a, int b) {  //ans
		a = a;
		for(int i  = 2 ; i <=b ; i++) {
			a *= a; // Can't import Math.
		}
	}
}

public class Class09 {
	public static void main(String [] args) {
		Compute cmp = new Compute();
		
		cmp.mul(3,5);
		cmp.show();
		cmp.mod(14,5);
		cmp.show();
		cmp.fac(5);
		cmp.show();
	}
}

/*
Output¡G
ans = 15
ans = 4
ans = 120
*/