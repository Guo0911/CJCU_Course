package Java08;

public class Class12 {
	public static void main(String args []) {
		CWin cw = new CWin();
		cw.setName("My Windows");
		cw.setW(5);
		cw.setH(3);
		cw.show();
		
		CWin cw2 = new CWin();
		cw2.setWindows(5, 3, "My Windows 2"); //(c)
		cw2.show();
	}
}
//(a).(b).(c)¬Ò¦bCwinÀÉ®×¤º¡C

/*
 print{
	Name = My Windows
	W = 5, H = 3
	Name = My Windows 2
	W = 5, H = 3
}
*/
