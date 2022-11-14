package Class05;

public class Class05 {
	public static void main(String [] args) {
		int num = 12;
		int den[] = {12,0,3,0,0,4};
		
		for(int i = 0; i < 10; i++) {
			try { //ans
				System.out.println("ans = " + num/den[i]);
			}
			catch(ArithmeticException e) { //ans
				System.out.println("除數為0");
			}
			catch(ArrayIndexOutOfBoundsException e) { //ans
				System.out.println("陣列索引值超出了範圍");
			}
		}
	}
}

/*
Output:
ans = 1
除數為0
ans = 4
除數為0
除數為0
ans = 3
陣列索引值超出了範圍
陣列索引值超出了範圍
陣列索引值超出了範圍
陣列索引值超出了範圍
*/