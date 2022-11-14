package Java08;

public class CCalculator {
	int a,b,c;
	void set_value(int x, int y, int z){ //(a)
		this.a = x;
		this.b = y;
		this.c  = z;
	}
	
	void show() { //(b)
		System.out.println("a = " + a );
		System.out.println("b = " + b );
		System.out.println("c = " + c );
	}
	
	int add() { //(c)
		return a+b+c;
	}
	
	int sub() { //(d)
		return a-b-c;
	}
	
	int mul() { //(e)
		return a*b*c;
	}
	
	double avg(){ //(f)
		double number = a+b+c;
		return (number/3);
	}
	
}
