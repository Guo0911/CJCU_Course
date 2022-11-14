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
			System.out.println(name + " ���ƾǤ�^��n");
		}
		else if (english > math) {
			System.out.println(name + " ���^���ƾǦn");
		}
		else {
			System.out.println(name + " �����ƬۦP");
		}
	}
	
	public void failed() {
		if(math < 60) {
			System.out.println(name + " ���ƾǷ��F");
		}
		else if (english < 60) {
			System.out.println(name + " ���^����F");
		}
		else if (english < 60 && math < 60){
			System.out.println(name + " ��쳣���F");
		}
		else {
			System.out.println(name + " ��쳣�ή�");
		}
	}
	
	public void showData() {
		System.out.println("�m�W�G" + name);
		System.out.println("�ƾǦ��Z�G" + math);
		System.out.println("�^�妨�Z�G" + english);
	}
	
	public double average() {
		return ((math + english) / 2.0);
	}
	
	public void show() {
		System.out.println("�m�W�G" + name);
		System.out.println("�ƾǦ��Z�G" + math);
		System.out.println("�^�妨�Z�G" + english);
		System.out.println("�������Z�G" + average());
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
�m�W�GJudy
�ƾǦ��Z�G58
�^�妨�Z�G91
�������Z�G74.5
Judy ���^���ƾǦn
Judy ���ƾǷ��F
------------------*/