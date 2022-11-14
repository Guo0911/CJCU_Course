package Java08;

public class Class16 {
	public static void main(String args []) {
		CSphere obj = new CSphere();
		
		obj.setLocation(3, 4, 5); //(a)
		
		obj.setRadius(1);
		
		System.out.println("surfaceArea = " + obj.surfaceArea());
		
		System.out.println("volume = " + obj.volume());
		
		obj.showCenter();
	}
}
//(a).(b).(c).(d).(e)¬Ò¦bCSphereÀÉ®×¤º¡C

/*
print{
	surfaceArea = 12.56
	volume = 3.14
	x = 3
	y = 4
	z = 5
}
*/