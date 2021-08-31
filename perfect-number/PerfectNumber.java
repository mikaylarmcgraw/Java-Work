import java.util.*;
public class PerfectNumber
{
    public static int x = 0;
    public static int result = 0;
    
    public static void main(String args[]) 
    { 
       //initalizing variables
       int n = 0;
       int result = 0; 
       
       //creating scanner object
       Scanner scanner = new Scanner(System.in);
       
       //capturing user input here
       System.out.println("Please enter the number of test cases you would like to do: ");
       n = scanner.nextInt();
       
       //iterating through this n number of specified times 
       for (int i = 1; i <= n; i++)
       {
           System.out.println("Please enter the number you wish to test if it's perfect: ");
           x = scanner.nextInt();
           result = isPerfect(x);
           
           //display result back to user.
           System.out.println("result " + result);
           System.out.println("x " + x);
           if(result == x)
           {
               System.out.println(x + " eh perfeito!");
           }
           else 
           {
               System.out.println(x + " nao eh perfeito!");
           }
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
