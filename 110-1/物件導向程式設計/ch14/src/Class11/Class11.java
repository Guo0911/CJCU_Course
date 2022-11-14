package Class11;

import java.io.*;

public class Class11 {
	public static void main(String args[]) throws IOException{
		String dir = System.getProperty("user.dir") + File.separator + "src" + File.separator + "Class11";
		String file_Path = dir + File.separator + "number.txt";
		
		FileInputStream fis = new FileInputStream(file_Path); //ans
		byte[] by = new byte[fis.available()];
		int count = 0;
		
		fis.read(by);
		System.out.println(new String(by));
	}
}

/*
Output:
12
34
63
14
16
56
*/