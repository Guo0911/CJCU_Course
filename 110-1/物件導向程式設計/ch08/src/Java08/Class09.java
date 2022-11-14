package Java08;

public class Class09 {
	public static void main (String args []) {
		CCalculator num = new CCalculator();
		num.set_value(25, 3, 7); //(a)
		num.show();
		System.out.println("a+b+c = " + num.add());
		System.out.println("a-b-c = " + num.sub());
		System.out.println("a*b*c = " + num.mul());
		System.out.println("(a+b+c)/3 = " + num.avg());
	}
}
//(b).(c).(d).(e).(f)¬Ò¦bCCalculatorÀÉ®×¤º¡C

/*
print{
	a = 25
	b = 3
	c = 7
	a+b+c = 35
	a-b-c = 15
	a*b*c = 525
	(a+b+c)/3 = 11.666666666666666
}
*/