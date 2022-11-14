package Java10;

public class Class20 {
	public static void main(String [] args) {
		CRectangle rect = new CRectangle(2,6);
		
		System.out.println(rect.toString(100,0));
		
		System.out.println(rect.toString(0,100));
	}
}

/*
If you want to see question (a).(b), please open the file name CRectangle.

Output:
length = 2, width = 6, area = 12
Argument Error
*/