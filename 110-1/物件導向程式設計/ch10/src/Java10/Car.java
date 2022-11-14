package Java10;

class Car {
	protected static String owner;
	protected static String id;
	
	public Car(String own , String s) {
		CRectangle(own,s);
	}
	
	public void CRectangle(String own , String s) { //(17).a
		owner = own;
		id = s;
	}
	
	final static void show(CColor obj) {
		System.out.println("車主姓名:" + owner);
		System.out.println("車牌號碼:" + id);
		System.out.println("車身顏色:" + obj.color);
	}
}

class CColor extends Car{ //(17).b
	public String color;
	
	public CColor(String own , String s) { //(17).c
		super(own,s);
	}
	
	public CColor(String own , String s , String co) {
		super(own,s);
		color = co;
	}
	
	/*
	public void show() { //(17).d
		System.out.println("車主姓名:" + owner);
		System.out.println("車牌號碼:" + id);
		System.out.println("車身顏色:" + color);
	}
	*/
	
}