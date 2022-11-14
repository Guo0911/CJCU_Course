package Class08;
import Class08.subpack1.CCircle;
import Class08.subpack2.CRectangle;
import Class08.subpack1.subpack.CStyle;


public class Class08
{
   public static void main(String args[])
   {
      CCircle cir=new CCircle();
      CRectangle rect=new CRectangle();
      CStyle sty= new CStyle(1); //ans
      cir.show();
      rect.show();
   }
}

/*
Output:
style = 1
show() in class CCircle called
show() in class CRectangle called
*/