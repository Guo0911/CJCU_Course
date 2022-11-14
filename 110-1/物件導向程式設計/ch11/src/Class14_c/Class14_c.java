package Class14_c;

import java.lang.Math;

interface iVolume{
	public void showData();
	public double vol();
}

abstract class CSphere implements iVolume{
	final double PI = 3.14;
	protected int r;
	protected int x ;
	protected int y;
	
	public void showData() { //(c)
		System.out.println("球心：(" + x + "," + y +")");
		System.out.println("半徑：" + r);
		System.out.println("球體積：" + vol());
	}
	
	public double vol() { //(c)
		return ((4/3.0) * PI * Math.pow(r, 3));
	}
}

class CCircle extends CSphere{
	public CCircle(int x_, int y_, int radious) {
		x = x_;
		y = y_;
		r = radious;
	}
}

public class Class14_c {
	public static void main(String [] args) {
		CCircle cir = new CCircle(8, 6, 2);
		cir.showData();	
	}
}

/*
If you want to see question (a) and (b). Please, go to package name Class14.

Output：
球心：(8,6)
半徑：2
球體積：33.49333333333333
*/