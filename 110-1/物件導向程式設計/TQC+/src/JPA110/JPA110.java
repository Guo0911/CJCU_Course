package JPA110;

class Test{
	private int r =5;
	private double pi = 3.1415926;
	
	private int base = 10;
	private int highet = 5;
	
	private int Long = 5;
	private int widht = 10;
	
	private double CirA, TriA, RecA;
	
	public void calCirecle(){
		CirA =  Math.pow(r, 2) * pi;
		System.out.println("��έ��n���G" + String.format("%.6f", CirA));
	}
	
	public void calTriangle() {
		TriA = base * highet / 2.0;
		System.out.println("�T���έ��n���G" + String.format("%.6f", TriA));
	}
	
	public void calRectangle() {
		RecA = Long * widht;
		System.out.println("��έ��n���G" + String.format("%.6f", RecA));
	}
	
	public void Graph() {
		System.out.println("���ϧέ��n���G" + String.format("%.6f", CirA + TriA + RecA));
	}
}

public class JPA110 {
	public static void main(String [] args) {
		Test t = new Test();
		t.calCirecle();
		t.calTriangle();
		t.calRectangle();
		t.Graph();
	}
}
