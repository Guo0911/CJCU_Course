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
		System.out.println("請輸入名稱:");
		String name = sc.next();
		System.out.println("請輸入英文分數:");
		int eng = sc.nextInt();
		System.out.println("請輸入數學分數:");
		int ma = sc.nextInt();
		Data one = new Data(name,eng,ma);
		
		System.out.println("請輸入名稱:");
		String name2 = sc.next();
		System.out.println("請輸入英文分數:");
		int eng2 = sc.nextInt();
		System.out.println("請輸入數學分數:");
		int ma2 = sc.nextInt();
		Data two = new Data(name2,eng2,ma2);
		
		one.show();
		two.show();
	}
}

/*
print:
請輸入名稱:
Annie
請輸入英文分數:
85
請輸入數學分數:
92
請輸入名稱:
Brian
請輸入英文分數:
77
請輸入數學分數:
56
name:Annie english=85 math=92 avg=88.5
name:Brian english=77 math=56 avg=66.5
*/
