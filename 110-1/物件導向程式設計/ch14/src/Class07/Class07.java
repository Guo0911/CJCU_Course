package Class07;

import java.io.*;

public class Class07 {
	public static void main(String [] args) throws IOException{
		String dir = System.getProperty("user.dir");
		String filePath = dir + File.separator + "src" + File.separator + "Class07" + File.separator + "donkey.txt";
		
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		String str;
		int count = 0;
		int strLength = 0;
		System.out.print("txt content is \n");
	
		while((str = br.readLine()) != null){
			if(count == 1) {
				br.skip(13); //ans
			}
			System.out.println(str);
			strLength += str.length();
			count++;
		}
					
		System.out.println("txt word count = " + strLength);
	}
}

/*
Output:
txt content is 
我有一隻小毛驢
我從來也不騎
txt word count = 13
*/