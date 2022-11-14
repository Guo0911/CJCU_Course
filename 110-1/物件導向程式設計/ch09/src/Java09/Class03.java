package Java09;

public class Class03 {
	public static void main (String [] args) {
		Caaa obj1 = new Caaa();
		Caaa obj2 = new Caaa(12);
	}
}
//(a)在Caaa檔案內。

/*
 * (b)
 * 05行呼叫的是Caaa中的「public Caaa()」
 * 06行呼叫的是Caaa中的「public Caaa(int i)」	
 * 
 * (c)
 * 不能；public class接續必須是該檔案名稱，且若使用public可能造成後續其他程式創建同樣名稱或呼叫該名稱的功能時產生錯誤。
 * 
 * (d)
 * 沒有影響；praivate為Caaa內，而05、06行呼叫的建構元都是在Caaa內，因此並不影響使用。
 * 
 * print:
 * value = 10
 * value = 12
 */