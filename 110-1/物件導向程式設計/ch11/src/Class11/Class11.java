package Class11;

interface Data{
	public void showData();
}

interface Test{
	public void showScore();
	
	public double calcu();
}

class CStu implements Data,Test{ //ans
	protected String id;
	protected String name;
	protected int mid;
	protected int finl;
	protected int common;
	
	public CStu(String ID, String na, int m, int f, int c) {
		id = ID;
		name =  na;
		mid = m;
		finl = f;
		common = c;
	}

	public void showData() {
		System.out.println("學號：" + id);
		System.out.println("姓名：" + name);
	}
	
	public void showScore() {
		System.out.println("期中：" + mid);
		System.out.println("期末：" + finl);
		System.out.println("平時：" + common);
	}
	
	public double calcu() {
		return (mid*0.3) + (finl*0.3) + (common*0.4);
	}
	
	public void show() {
		System.out.println("學號：" + id);
		System.out.println("姓名：" + name);
		System.out.println("期中：" + mid);
		System.out.println("期末：" + finl);
		System.out.println("平時：" + common);
		System.out.println("學期成績：" + calcu());
	}
}

public class Class11 {
	public static void main(String [] args) {
		CStu stu = new CStu("940001", "Fiona", 90, 92, 85);
		stu.show();
	}
}

/*
Output：
學號：940001
姓名：Fiona
期中：90
期末：92
平時：85
學期成績：88.6
*/