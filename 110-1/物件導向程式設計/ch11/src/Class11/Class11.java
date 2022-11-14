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
		System.out.println("�Ǹ��G" + id);
		System.out.println("�m�W�G" + name);
	}
	
	public void showScore() {
		System.out.println("�����G" + mid);
		System.out.println("�����G" + finl);
		System.out.println("���ɡG" + common);
	}
	
	public double calcu() {
		return (mid*0.3) + (finl*0.3) + (common*0.4);
	}
	
	public void show() {
		System.out.println("�Ǹ��G" + id);
		System.out.println("�m�W�G" + name);
		System.out.println("�����G" + mid);
		System.out.println("�����G" + finl);
		System.out.println("���ɡG" + common);
		System.out.println("�Ǵ����Z�G" + calcu());
	}
}

public class Class11 {
	public static void main(String [] args) {
		CStu stu = new CStu("940001", "Fiona", 90, 92, 85);
		stu.show();
	}
}

/*
Output�G
�Ǹ��G940001
�m�W�GFiona
�����G90
�����G92
���ɡG85
�Ǵ����Z�G88.6
*/