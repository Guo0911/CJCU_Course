package Java09;

public class Class08 {
	public static void main(String[] args) {
		Cwin a = new Cwin();
		a.count();
		System.out.println(a.cnt);
	}
	
}

/*
(a).(b).(c).(d).(e)皆在Cwin檔案內。

(f)cnt為Cwin內的一個變數，無法直接呼叫，需透過物件來呼叫，因此cnt為實例變數

(g)count()為Cwin內的一個函數，無法直接呼叫，需透過物件來呼叫，因此count()為實例函數

*/
