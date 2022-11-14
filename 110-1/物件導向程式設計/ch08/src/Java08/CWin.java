package Java08;

public class CWin {
	int width;
	int height;
	String name;
	
	void setW(int w) { //(a)
		this.width = w;
	}
	
	void setH(int h) { //(a)
		this.height = h;
	}
	
	void setName(String s) {
		this.name = s;
	}
	
	public void show() {
		System.out.println("Name = " + name);
		System.out.println("W = " + width + ", H = " + height);
	}
	
	void setWindows(int w , int h , String n) { //(b)
		this.width = w;
		this.height = h;
		this.name = n;
	}
}