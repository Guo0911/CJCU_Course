package Class09;

import Class09.sub1.CSphere;
import Class09.sub2.CTrapezoid;

public class Class09 {
	public static void main(String [] args) {
		CSphere csp = new CSphere(5);
		CTrapezoid ctr = new CTrapezoid(1,2,3);
		csp.show();
		ctr.show();
	}
}

/*
(a).(b) If you want to see CSphere. Please, open package name Class09.sub1.
(c).(d) If you want to see CTrapezoid. Please, open package name Class09.sub2.
I think (d) is to create show function for CTrapezoid not CSphere, so I wrote (d) in class CTrapezoid. Thank you.

Output:
radius = 5.0
volume = 523.3333333333334
upper  = 1
base   = 2
height = 3
area   = 4.5
*/