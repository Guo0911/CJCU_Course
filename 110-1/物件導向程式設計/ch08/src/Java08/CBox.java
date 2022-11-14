package Java08;

public class CBox {
	int length;
	int width;
	int height;
	
	int volume() { //(b)
		return length*width*height;
	}
	
	int surfaceArea() { //(c)
		return length*width;
	}
	
	void showData() { //(d)
		System.out.println("length = " + length);
		System.out.println("width = " + width);
		System.out.println("height = " + height);
	}
	
	void showAll() { //(e)
		System.out.println("length = " + length);
		System.out.println("width = " + width);
		System.out.println("height = " + height);
		System.out.println("volume = " + volume());
		System.out.println("surfaceArea = " + surfaceArea());
	}
}
