import java.util.*;
class Main
{
    public static long x = 0;
    public static long result = 0;

    public static void main(String[] args)
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
               System.out.println(x + " eh perfeito");
           }
           else 
           {
               System.out.println(x + " nao eh perfeito");
           }
           //reset result value
           result = 0;
       }

    }
    
    public static long isPerfect(long testValue)//function to calculate if a number is perfect
    {  
        while (testValue != 0)
        {
            if (x % testValue == 0 && x != testValue) //if a positive divisor add to the result
            {
               result = result + testValue;
            }
            testValue--;
        }
            return result;
    }
}
