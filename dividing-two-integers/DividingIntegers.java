import java.util.Scanner;

public class DividingIntegers
{
  public static void main(String args[])
  {
      //initalizing variables
      int a = 0;
      int b = 0;
      int result = 0;
      
      //creating my scanner object
      Scanner scanner = new Scanner(System.in);
      
      //getting user inputs
      System.out.println("Please enter the dividend in the problem: ");
      a = scanner.nextInt();
      System.out.println("Please enter the divisor in the problem: ");
      b = scanner.nextInt();
      
      if (b == 0)
      {
          System.out.println("Cannot divide by 0, please restart program and try again.");
      }
      else
      {
         //calculating the result calling divide method
         result = divide(a, b);
      
         //display result back to user
         System.out.println(a + "/" + b + "= " + result); 
      }
  }
  
  public static int divide(int x, int y)
  {
      return (x / y);
  }
}
