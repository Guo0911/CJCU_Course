package Class06;

import java.io.*;

public class Class06 {
	public static void main(String args[]){
		try { //ans
			String dir = System.getProperty("user.dir");
			String filePath = dir + File.separator + "src" + File.separator + "Class06" + File.separator + "train.txt";
			
			FileReader fr = new FileReader(filePath);
			
			char data[] = new char[128];
			
			int num = fr.read(data);
			String str = new String(data,0,num);
			System.out.println("Characters read= "+num);
			System.out.println(str);
			
			fr.close();
		}
		catch(IOException e){ //ans
			System.out.println(e);
		}
	}
}

/*
Output:
Characters read= 29
火車快飛，火車快飛
越過高山，飛過小溪
不知走了幾百里

*/