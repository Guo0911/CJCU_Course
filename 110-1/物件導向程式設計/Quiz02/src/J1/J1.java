package J1;

import java.util.Scanner;

class  RuntimeException extends Exception{
    public RuntimeException(){
    }
    
	public String getMessage(){
        return ("��J�T�����~�I�{������I");
	}
}

public class J1 {
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("��J�K�X����");
		System.out.print("�п�J�K�X�G");
		int input = sc.nextInt();
		while(input<1000 || input >9999) {
			System.out.println("�п�J�|���ƪ��K�X");
			System.out.print("�п�J�K�X�G");
			input = sc.nextInt();
		}
		int err_times = 0;
		
		try {
			System.out.print("�ЦA��J�@���K�X�G");
			int input2 = sc.nextInt();
			while(input != input2) {
				err_times ++ ;
				if(err_times == 3) {
					 throw new RuntimeException();
				}
				System.out.print("�ЦA��J�@���K�X�G");
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
��J�K�X����
�п�J�K�X�G12345
�п�J�|���ƪ��K�X
�п�J�K�X�G1234
�ЦA��J�@���K�X�G1231231
�ЦA��J�@���K�X�G1231321
�ЦA��J�@���K�X�G2132132
J1.RuntimeException: ��J�T�����~�I�{������I
	at J1.J1.main(J1.java:34)
*/