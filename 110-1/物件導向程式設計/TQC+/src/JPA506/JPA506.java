package JPA506;

public class JPA506 {
	public static void main(String [] args) {
		int[][][] A = {{{1,2,3},{4,5,6}},
							    {{7,8,9},{10,11,12}},
							    {{13,14,15},{16,17,18}},
							    {{19,20,21},{22,23,24}}};
		int sum = 0;
		
		for(int i = 0 ; i < A.length ; i++) {
			for(int j = 0 ; j < A[i].length ; j++) {
				for(int k = 0 ; k< A[i][j].length ; k++) {
					sum += A[i][j][k];
				}
			}
		}
		
		System.out.println("sum = " + sum);
	}
}
