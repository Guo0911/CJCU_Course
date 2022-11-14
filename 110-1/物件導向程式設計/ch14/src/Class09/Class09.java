package Class09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Class09 {
	public static void main(String [] args) throws IOException{
		String dir = System.getProperty("user.dir") + File.separator + "src" + File.separator + "Class09";
		String file_a_Path = dir + File.separator + "aaa.txt";
		String file_b_Path = dir + File.separator + "bbb.txt";
		String file_c_Path = dir + File.separator + "ccc.txt";
		
		FileReader fra = new FileReader(file_a_Path);
		BufferedReader bra = new BufferedReader(fra);

		FileReader frb = new FileReader(file_b_Path);
		BufferedReader brb = new BufferedReader(frb);

		FileReader frc = new FileReader(file_c_Path);
		BufferedReader brc = new BufferedReader(frc);
		
		String str;

		System.out.print("aaa.txt content is \n"); //ans
		while((str = bra.readLine()) != null){
			System.out.println(str);
		}

		System.out.print("\nbbb.txt content is \n"); //ans
		while((str = brb.readLine()) != null){
			System.out.println(str);
		}

		System.out.print("\nccc.txt content is \n"); //ans
		while((str = brc.readLine()) != null){
			System.out.println(str);
		}
	}
}

/*
Output:
aaa.txt content is 
Look before you leap.

bbb.txt content is 
Make hay while the sun shines.

ccc.txt content is 
Look before you leap.
Make hay while the sun shines.
*/