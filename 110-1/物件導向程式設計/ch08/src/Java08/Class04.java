package Java08;

public class Class04 {
	public static void main (String arge []) {
		CBox box = new CBox();
		
		//ans{
		box.length = 15;
		box.width  = 10;
		box.height = 25;
		//}
		
		System.out.println("length = " + box.length);
		System.out.println("width = " + box.width);
		System.out.println("height = " + box.height);
	}
}

/*
print{
	length = 15
	width = 10
	height = 25
}
*/
