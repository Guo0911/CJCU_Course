package Class01;

abstract class CShape
{
   protected String color;
   
   public CShape(String str) {  //Ans
	   color = str;
   }
   
   public void setColor(String str)
   {
      color=str;
   }
   public abstract void show();
}


class CRectangle extends CShape
{
   protected int width,height;
   
   public CRectangle(String str, int w, int h)
   {
	  super(str);
      width=w;
      height=h;
   }
   
   public void show()
   {
      System.out.print("color = " + color+",  ");
      System.out.println("area = " + width*height);
   }
}
class CCircle extends CShape
{
   protected double radius;
   
   public CCircle(String str, double r)
   {
	  super(str);
      radius=r;
   }
   
   public void show()
   {
      System.out.print("color = " + color+",  ");
      System.out.println("area = " + 3.14*radius*radius);
   }
}

public class Class01
{
   public static void main(String args[])
   {
      CRectangle rect=new CRectangle("Yellow", 5, 10);
      rect.show();

      CCircle cir=new CCircle("Green", 2.0);
      cir.show();
   }
}

/*
Output¡G
color = Yellow,  area = 50
color = Green,  area = 12.56
*/