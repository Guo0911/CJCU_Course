package Class04;

import java.io.*;

public class Class04 {
	public static void main(String [] args) throws IOException{
		String dir = System.getProperty("user.dir");
		String filePath = dir + File.separator + "src" + File.separator + "Class04" + File.separator + "donkey.txt";
		
		FileReader fr = new FileReader(filePath); //4.(a)
		
		char data[] = new char[128];
		int txtLength = fr.read(data);
		String str = new String(data,0,txtLength);
		
		System.out.println("txt word count = " + txtLength); //4.(a)
		System.out.println("txt content is \n" + str);
	}
}

/*
(b) Because the txt has two \r and \n, so its word count will increase by 4.

Output:
txt word count = 30
txt content is 
我有一隻小毛驢
我從來也不騎
有一天我心血來潮騎著去趕集
*/