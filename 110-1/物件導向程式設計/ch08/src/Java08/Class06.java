package Java08;

public class Class06 {
	public static void main (String args[]) {
		CCircle cir1 = new CCircle(); //(a)
		
		cir1.radius = 3.0; //(b)
		
		cir1.show_periphery(); //(d)
		
	}
}
//(c)因設定的變數不需要使用this，且第13題也需要在CCircle標記，因此在CCircle並沒有標記此題的(c)，但CCircle檔案內的函數有使用。

/*
print{
	periphery = 18.84
}
*/