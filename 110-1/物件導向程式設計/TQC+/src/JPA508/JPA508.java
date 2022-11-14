package JPA508;

public class JPA508 {
	public static void main(String [] args) {
		int[] sort = {2,4,3,5,7,6,9,1};
		
		for(int i = 0 ; i < sort.length-1 ; i++) {
			for(int j = 1 ; j < sort.length ; j++) {
				if(sort[j-1] > sort[j]) {
					int num = sort[j];
					sort[j] = sort[j-1];
					sort[j-1] = num;
				}
			}
			
			for(int j = 0 ; j < sort.length ; j++) {
					System.out.print(" " + sort[j]);
			}
			
			System.out.println();
		}
	}
}
