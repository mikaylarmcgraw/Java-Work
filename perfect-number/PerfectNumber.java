import java.util.*;
public class PerfectNumber
{
    public static int x = 0;
    public static int result = 0;

    public static void main(String args[]) 
    { 
       //initalizing variables
       int n = 0;


       //creating scanner object
       Scanner scanner = new Scanner(System.in);
       
       //capturing number of iterations here
       n = scanner.nextInt();
       
       //iterating through this n number of specified times 
       for (int i = 1; i <= n; i++)
       {
           x = scanner.nextInt();
           result = isPerfect(x);

           if(result == x)
           {
               System.out.println(x + " eh perfeito!");
           }
           else 
           {
               System.out.println(x + " nao eh perfeito!");
           }
           //reset result value
           result = 0;
       }

    }
    
    public static int isPerfect(int testValue)//function to calculate if a number is perfect
    {  
        if (testValue != 0)
        {
            isPerfect(testValue - 1);
            if (x % testValue == 0 && x != testValue) //if a positive divisor add to the result
            {
               result = result + testValue;
            }

        }
            return result;
    }
}
