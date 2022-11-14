package Java09;

public class Class05 {
	public static void main(String [] args) {
		CCount a = new CCount();
		a.count();
		System.out.println(a.cnt);
	}
}

/*
(a).(b).(c) 皆在CCount檔案內。

(d)cnt為CCount內的一個變數，無法直接呼叫，需透過物件來呼叫，因此cnt為實例變數

(e)count()為CCount內的一個函數，無法直接呼叫，需透過物件來呼叫，因此count()為實例函數

*/