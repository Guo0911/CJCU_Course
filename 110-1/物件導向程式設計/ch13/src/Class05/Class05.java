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
				System.out.println("���Ƭ�0");
			}
			catch(ArrayIndexOutOfBoundsException e) { //ans
				System.out.println("�}�C���ޭȶW�X�F�d��");
			}
		}
	}
}

/*
Output:
ans = 1
���Ƭ�0
ans = 4
���Ƭ�0
���Ƭ�0
ans = 3
�}�C���ޭȶW�X�F�d��
�}�C���ޭȶW�X�F�d��
�}�C���ޭȶW�X�F�d��
�}�C���ޭȶW�X�F�d��
*/