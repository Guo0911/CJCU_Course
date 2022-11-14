package Class10;

import java.io.*;

public class Class10 {
	public static void main(String [] args) throws IOException{        

// -------------------------------------(a)
		
		String dir = System.getProperty("user.dir") + File.separator + "src" + File.separator + "Class10";
		String file_r_Path = dir + File.separator + "rand.txt";
		
		FileWriter fwr = new FileWriter(file_r_Path);  
        BufferedWriter bwr = new BufferedWriter(fwr);
        
        for(int i = 0 ; i < 1000 ; i++)
        {
           int num= (int)(Math.random()*100000);
           bwr.write(Integer.toString(num));
           bwr.newLine();
        }
        bwr.flush();
        
// -------------------------------------(b)

		FileReader frr = new FileReader(file_r_Path);  
        BufferedReader brr = new BufferedReader(frr);
        String str;
        int number ,max = 0, min = 100000, avg = 0;
        int[] number_ar = new int[1000];
        int count = 0;

		while((str = brr.readLine()) != null){
			number = Integer.parseInt(str);
			if(number > max) {
				max = number;
			}
			if(number < min) {
				min = number;
			}
			avg += number;
			number_ar[count] = number;
			count ++;
		}
		
		avg /= 1000;
		System.out.println("the 1000 random max is " + max);
		System.out.println("the 1000 random min is " + min);
		System.out.println("the 1000 random avg is " + avg);
		

// -------------------------------------(c)		

		int max_, finalIndex = 1000;
		
		while(finalIndex != 0) {
			max = number_ar[0];
			for(int i = 1 ; i < finalIndex ; i++) {
				if(number_ar[i] > max) {
					max = number_ar[i];
				}
				if(number_ar[i-1] > number_ar[i]) {
					int change = number_ar[i-1];
					number_ar[i-1] = number_ar[i];
					number_ar[i] = change;
				}
			}
			if(number_ar[finalIndex-1] == max) {
				finalIndex -= 1;
			}
		}
		
		String file_r2_Path = dir + File.separator + "rand2.txt";
		
		FileWriter fwr2 = new FileWriter(file_r2_Path);  
        BufferedWriter bwr2 = new BufferedWriter(fwr2);
        
        for(int i = 0 ; i < 1000 ; i++)
        {
           bwr2.write(Integer.toString(number_ar[i]));
           bwr2.newLine();
        }
        bwr2.flush();
	}
}

/*
The sort function I use is bubble sort.

Output:
the 1000 random max is 99767
the 1000 random min is 115
the 1000 random avg is 49922
*/