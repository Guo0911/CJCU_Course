package Class08;

import java.io.*;

public class Class08 {
	public static void main(String [] args) throws IOException{
		String dir = System.getProperty("user.dir") + File.separator + "src" + File.separator + "Class08";
		String file_a_Path = dir + File.separator + "aaa.txt";
		String file_b_Path = dir + File.separator + "bbb.txt";
		String file_c_Path = dir + File.separator + "ccc.txt";
		
		FileReader fra = new FileReader(file_a_Path);
		BufferedReader bra = new BufferedReader(fra);

		FileReader frb = new FileReader(file_b_Path);
		BufferedReader brb = new BufferedReader(frb);
		
		String str;
		String str_all = "";
		System.out.print("txt content is \n");
	
		while((str = bra.readLine()) != null){
			str_all += str + "\r\n"; //ans
		}
		
		while((str = brb.readLine()) != null){
			str_all += str; //ans
		}
		
		System.out.println(str_all);
		
		FileWriter fw = new FileWriter(file_c_Path);  
        BufferedWriter bw = new BufferedWriter(fw);  
           
        bw.write(str_all); //ans
        bw.flush();
	}
}

/*
If you want to see ccc.txt, please open the file name ccc.txt in this folder.

Output:
txt content is 
Look before you leap.
Make hay while the sun shines.
*/