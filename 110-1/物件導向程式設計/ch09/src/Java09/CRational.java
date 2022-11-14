package Java09;

public class CRational {
	public int n;
	public int d;
	
	public void setN(int num) {
		n = num;
	}
	
	public void setD(int num) {
		d = num;
	}
	
	public void setND(int num,int den) { //(a)
		n = num;
		d = den;
	}
	
	public void show() {
		System.out.println(n+"/"+d);
	}
}
