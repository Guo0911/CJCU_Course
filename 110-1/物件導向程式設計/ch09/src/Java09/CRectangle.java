package Java09;

public class CRectangle {
	int width;
	int height;
	
	void CRectangle(int w , int h) { //(a)
		width = w;
		height = h;
	}
	
	void CRectangle() { //(b)
		width = 10;
		height = 8;
	}
	
	void CRectangleT() { //(c)
		this.width = 10;
		this.height = 8;
	}
}
