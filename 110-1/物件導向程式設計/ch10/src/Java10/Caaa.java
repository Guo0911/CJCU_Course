package Java10;

class Caaa{
	public int num1;
	public int num2;
	private int num;
	
	public Caaa() { //(3).a
		num1 = 1;
		num2 = 1;
		System.out.println("Call Caaa() to create num1 = " + num1 + " and num2 = " + num2);
	}
	
	public Caaa(int a) { //(3).a
		num = a;
		System.out.println("Call Caaa(a) to create num1 = " + num);
	}
	
	public Caaa(int a , int b) { //(3).b
		num1 = a;
		num2 = b;
		System.out.println("Call Caaa(a,b) to create num1 = " + num1 + " and num2 = " + num2);
	}
	
	public int get() {
		return num;
	}
	
	public void display() {  //(09).a
		System.out.println("printed from Caaa class");
	}
	
}

class Cbbb extends Caaa{
	
	public Cbbb() { //(13)
	}

	public Cbbb(int a) { //I correct it for (5)
		super(a);
	}
	
	public Cbbb(int a , int b) { //(3).c and (14)
		super(a,b);
		System.out.println("Call Cbbb(a,b) to create num1 = " + num1 + " and num2 = " + num2);
	}
	
	void set_num(int a , int b) { //(1)
		num1 = a;
		num2 = b;
	}
	
	void show() { //(1)
		System.out.println("num1 = " + num1 +",num2 = " + num2);
	}
	
	public void show_for_C05() { //(1)
		System.out.println("num = " + get());
	}
	
	public void display() {  //(09).b
		System.out.println("printed from Cbbb class");
	}
}
