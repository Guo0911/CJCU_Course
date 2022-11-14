package Java10;

public class Class17 {
	public static void main(String[]args) {
		CColor mycar = new CColor("Riaan","A1-2345","Black");
		Car.show(mycar);
	}
}

/*
If you want to see question (a).(b).(c).(d), please open the file name Car.

(17).e -> 
1.owner and id add static
2.final void show() -> correct to -> final static void show(CColor obj)
3.show of Car add System.out.println("車身顏色:" + obj.color);

Output:
車主姓名:Riaan
車牌號碼:A1-2345
車身顏色:Black
*/