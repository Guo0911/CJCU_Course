package Class05;

import java.io.*;

public class Class05 {
	public static void main(String [] args) throws IOException{
		String dir = System.getProperty("user.dir");
		String filePath = dir + File.separator + "src" + File.separator + "Class05" + File.separator + "donkey.txt";
		
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		br.readLine(); //ans , this line is the first line.
		String str;
		int txtLength = 0;
		
		System.out.print("txt content is \n");
		
		while((str = br.readLine()) != null)
		{
			System.out.println(str);
			txtLength += str.length();
		}
		
		System.out.println("txt word count = " + txtLength); //4.(a)
	}
}

/*
Output:
txt content is 
�ڱq�Ӥ]���M
���@�ѧڤߦ�Ӽ��M�ۥh����
txt word count = 19
*/