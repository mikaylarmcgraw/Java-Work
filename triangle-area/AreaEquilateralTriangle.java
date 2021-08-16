import java.util.Scanner;
class AreaEquilateralTriangle 
{
   public static void main(String args[]) 
    {   
          //creating scanner object
          Scanner s = new Scanner(System.in);
          
          //user input
          System.out.println("Enter the side of the Triangle:");
          double a = s.nextDouble();
          
          double area=(Math.sqrt(3)/4) * (Math.pow(a,2));
          
          System.out.println("Area of Triangle is: " + area);      
     }
}