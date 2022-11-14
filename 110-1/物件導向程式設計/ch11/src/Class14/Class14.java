package Class14;

import java.lang.Math;

interface iVolume{
	public void showData();
	public double vol();
}

abstract class CSphere implements iVolume{
	final double PI = 3.14;
	protected int x ;
	protected int y;
}

class CCircle extends CSphere{  //(a)
	protected int r;
	public CCircle(int x_, int y_, int radious) {
		x = x_;
		y = y_;
		r = radious;
	}
	
	public void showData() {
		System.out.println("�y�ߡG(" + x + "," + y +")");
		System.out.println("�b�|�G" + r);
		System.out.println("�y��n�G" + vol());
	}
	
	public double vol() {
		return ((4/3.0) * PI * Math.pow(r, 3));
	}
}

public class Class14 {
	public static void main(String [] args) {
		CCircle cir = new CCircle(8, 6, 2);
		cir.showData();	
	}
}

/*
(b)
CSphere is abstract class, so it's no need to write all functions.

If you want to see question (c). Please, go to package name Class14_c.

Output�G
�y�ߡG(8,6)
�b�|�G2
�y��n�G33.49333333333333
*/