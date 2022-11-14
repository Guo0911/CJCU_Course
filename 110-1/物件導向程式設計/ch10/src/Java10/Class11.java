package Java10;

public class Class11 { //(11).d
	public static void main(String [] args) {
		CCircle circle1 = new CCircle(5);
		CCircle circle2 = new CCircle(10);
		
		CSquare CSquare1 = new CSquare(5);
		CSquare CSquare2 = new CSquare(10);
		
		CSTrangle CSTrangle1 = new CSTrangle(5,5);
		CSTrangle CSTrangle2 = new CSTrangle(10,10);
		
		CShape.largest(circle1, circle2, CSquare1, CSquare2, CSTrangle1, CSTrangle2);
	}
}

/*
If you want to see question (a).(b).(c).(e), please open the file name CShape.

Output:
Max area = 314.0
*/