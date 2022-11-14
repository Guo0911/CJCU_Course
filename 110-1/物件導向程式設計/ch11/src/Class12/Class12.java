package Class12;

interface Data{
	public void best();
	public void failed();
}

interface Test extends Data{
	public void showData();
	public double average();
}

class CStu implements Test{
	protected String name ;
	protected int math;
	protected int english;
	
	public CStu(String na, int m, int e) { //ans
		name = na;
		math = m;
		english = e;
	}
	
	public void best() {
		if(math > english) {
			System.out.println(name + " 的數學比英文好");
		}
		else if (english > math) {
			System.out.println(name + " 的英文比數學好");
		}
		else {
			System.out.println(name + " 兩科分數相同");
		}
	}
	
	public void failed() {
		if(math < 60) {
			System.out.println(name + " 的數學當掉了");
		}
		else if (english < 60) {
			System.out.println(name + " 的英文當掉了");
		}
		else if (english < 60 && math < 60){
			System.out.println(name + " 兩科都當掉了");
		}
		else {
			System.out.println(name + " 兩科都及格");
		}
	}
	
	public void showData() {
		System.out.println("姓名：" + name);
		System.out.println("數學成績：" + math);
		System.out.println("英文成績：" + english);
	}
	
	public double average() {
		return ((math + english) / 2.0);
	}
	
	public void show() {
		System.out.println("姓名：" + name);
		System.out.println("數學成績：" + math);
		System.out.println("英文成績：" + english);
		System.out.println("平均成績：" + average());
		best();
		failed();
	}
}

public class Class12 {
	public static void main(String [] args) {
		System.out.println("/* output---------");
		CStu stu = new CStu("Judy", 58, 91);
		stu.show();
		System.out.println("------------------*/");
	}
}

/* output---------
姓名：Judy
數學成績：58
英文成績：91
平均成績：74.5
Judy 的英文比數學好
Judy 的數學當掉了
------------------*/