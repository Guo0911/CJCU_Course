package Quiz01;

import java.util.Scanner;
class Data{
	private String name;
	private Test score;
	
	
	class Test{
		private int english;
		private int math;
		
		public Test(int eng , int m) {
			english = eng;
			math = m;
		}
		
		public double avg() {
			return (english + math)/2.0;
		}
	}
	
	public Data(String na,int eng,int ma){
		name=na;
	    score=new Test(eng,ma);
	}
	
	public void show() {
		System.out.println("name:"+name+" english="+score.english+" math="+score.math+" avg="+score.avg());
	}
}
public class Class03 {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�п�J�W��:");
		String name = sc.next();
		System.out.println("�п�J�^�����:");
		int eng = sc.nextInt();
		System.out.println("�п�J�ƾǤ���:");
		int ma = sc.nextInt();
		Data one = new Data(name,eng,ma);
		
		System.out.println("�п�J�W��:");
		String name2 = sc.next();
		System.out.println("�п�J�^�����:");
		int eng2 = sc.nextInt();
		System.out.println("�п�J�ƾǤ���:");
		int ma2 = sc.nextInt();
		Data two = new Data(name2,eng2,ma2);
		
		one.show();
		two.show();
	}
}

/*
print:
�п�J�W��:
Annie
�п�J�^�����:
85
�п�J�ƾǤ���:
92
�п�J�W��:
Brian
�п�J�^�����:
77
�п�J�ƾǤ���:
56
name:Annie english=85 math=92 avg=88.5
name:Brian english=77 math=56 avg=66.5
*/
