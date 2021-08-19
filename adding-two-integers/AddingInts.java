import java.util.Scanner;

public class AddingInts
{
    public static void main(String args[])
    {
        //initalizing integers
        int a = 0;
        int b = 0;
        int result = 0;
        
        //creating scanner object
        Scanner userInput = new Scanner(System.in);
        
        //capturing user inputs
        System.out.println("Adding two integers! Please only enter in integers between 0 - 5");
        System.out.println("Please enter the first integer:");
        a = userInput.nextInt();
        
        //check if a is in range if it is move on to b
        if(a >=0 && a <=5)
        {
           System.out.println("Please enter the second integer:");
           b = userInput.nextInt();
           
           //check if b is in range if it is calculate results
           if (b >=0 && b <=5)
           {
               //calculating results and displaying to user
               result = addition(a, b);
               System.out.println(a + "+" + b + " = " + result);
           }
           else 
           {
               System.out.println("Sorry second input was out of range between 0-5 please restart program and enter in values between range.");
           }
        }
        else
        {
            System.out.println("Sorry first input was out of range between 0-5 please restart program and enter in values between range.");
        }

    }
    
    public static int addition(int x, int y)
    {
        return x + y;
    }
}