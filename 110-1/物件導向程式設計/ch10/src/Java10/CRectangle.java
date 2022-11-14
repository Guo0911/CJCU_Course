package Java10;

class CRectangle {
	protected int length;
	protected int width;
	
	public CRectangle(int l , int w) { //(19).a
		length = l;
		width = w;
	}
	
	public int area() {
		return length * width;
	}
	
	public String toString() {
		return "length = " + length + ", width = " + width + ", area = " + area();
	}
	
	public String toString(int a , int b) {
		if (a>=b) {return "length = " + length + ", width = " + width + ", area = " + area();} //(20).a
		else {return "Argument Error";} //(20).b
	}
}
