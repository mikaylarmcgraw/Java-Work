import java.util.Scanner;

public class GradeCalculator
{
    public static void main (String args[])
    {
          //no input error trapping necessary on main arguments
          int percentage = 0;
          
          //creating scanner object
          Scanner userInput = new Scanner(System.in);
          
          //user input portion
          System.out.println("Please enter your grade percentage as a whole number for example if you have a 50% please enter 50:");
          percentage=userInput.nextInt();
          
         if (percentage >= 0 && percentage < 60) 
         {
            System.out.println("Your grade is an 'F'");
         }
         else if (percentage >= 60 && percentage < 70) 
         {
            System.out.println("Your grade is a 'D'");
         }
         else if (percentage >= 70 && percentage < 80) 
         {
            System.out.println("Your grade is a 'C'");
         }
         else if (percentage >= 80 && percentage < 90) 
         {
            System.out.println("Your grade is a 'B'");
         }
         else if (percentage >= 90) 
         {
            System.out.println("Your grade is an 'A'");
         }
         else
         {
            System.out.println("Please restart program and enter a valid percentage between 0-100.");
         }
    }
}
