package J1;

import java.util.Scanner;

class  RuntimeException extends Exception{
    public RuntimeException(){
    }
    
	public String getMessage(){
        return ("輸入三次錯誤！程式停止！");
	}
}

public class J1 {
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("輸入密碼測試");
		System.out.print("請輸入密碼：");
		int input = sc.nextInt();
		while(input<1000 || input >9999) {
			System.out.println("請輸入四位整數的密碼");
			System.out.print("請輸入密碼：");
			input = sc.nextInt();
		}
		int err_times = 0;
		
		try {
			System.out.print("請再輸入一次密碼：");
			int input2 = sc.nextInt();
			while(input != input2) {
				err_times ++ ;
				if(err_times == 3) {
					 throw new RuntimeException();
				}
				System.out.print("請再輸入一次密碼：");
				input2 = sc.nextInt();
			}
		}
		catch(RuntimeException e){
			e.printStackTrace();
		}
	}
}

/*
Input and Output:
輸入密碼測試
請輸入密碼：12345
請輸入四位整數的密碼
請輸入密碼：1234
請再輸入一次密碼：1231231
請再輸入一次密碼：1231321
請再輸入一次密碼：2132132
J1.RuntimeException: 輸入三次錯誤！程式停止！
	at J1.J1.main(J1.java:34)
*/