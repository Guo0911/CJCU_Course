package Java10;

class CTrangle {
	protected int base;
	protected int height;
	
	protected void show() {
		System.out.println("base = " + base + " , height = " + height);
	}
}

class CData extends CTrangle{ //(6).a
	public CData(int a , int b) {
		base = a;
		height = b;
	}
	
	void area() { //(6).b
		show();
		System.out.println("area = " + ((base*height)/2.0));
	}
}
