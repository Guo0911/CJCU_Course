package Java08;

public class Class02{
	public static void main(String [] argv) {
		Cbbb obj1 = new Cbbb();  //(a)
		Cbbb obj2 = new Cbbb();  //(a)
		Cbbb avg   = new Cbbb(); //(a)
		
		obj1.x=5.2; obj1.y=3.9;  //(b)
		obj2.x=6.5; obj2.y=4.6;  //(c)
		avg.x =  (obj1.x + obj2.x)/2;  //(d)
		avg.y =  (obj1.y + obj2.y)/2;  //(e)
		
		
		//(f){
		System.out.println("obj1.x = "+obj1.x);
		System.out.println("obj1.y = "+obj1.y);
		System.out.println("obj2.x = "+obj2.x);
		System.out.println("obj2.y = "+obj2.y);
		System.out.println("avg.x = "+avg.x);
		System.out.println("avg.y = "+avg.y);
		//}
	}
}

/*
print{
	obj1.x = 5.2
	obj1.y = 3.9
	obj2.x = 6.5
	obj2.y = 4.6
	avg.x = 5.85
	avg.y = 4.25
}
*/