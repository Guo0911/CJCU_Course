package Java09;

public class Cwin {
	static int cnt = 0;
	
	String color;
	int width;
	int height;
	
	void count() {
		cnt ++ ;
	}
	
	void Cwin(String str , int w , int h) { // (b)
		color = str;
		width = w;
		height = h;
		count();
	}
	
	void Cwin() {  // (c)
		color = "red";
		width = 2;
		height = 2;
		count();
	}
	
	void setZero() { // (d)
		cnt = 0;
	}
	
	void setValue(int n) { // (e)
		cnt = n;
	}
}
