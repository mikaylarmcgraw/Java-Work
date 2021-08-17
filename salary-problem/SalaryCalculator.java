import java.util.Scanner;
public class SalaryCalculator
{
    public static void main (String args[])
    {
      //no input error trapping necessary on main arguments
      //setting integers
       int yearsWorked = 0;
       int salary = 0;
       double bonus = 0;
       
       //creating scanner object
       Scanner userInput = new Scanner(System.in);
       
       //user input
       System.out.println("Please enter numerically how many years you've been with the company:");
       yearsWorked=userInput.nextInt();
       
       //check to see if employee has been with company long enough
       if (yearsWorked >= 5)
       {
           System.out.println("Please enter salary amount:");
           salary = userInput.nextInt();
           
           //Calculating bonus portion
           bonus = bonusCalculator(salary);
           
           //display result to user
           System.out.println("Your bonus this year will be: " + bonus);
       } 
       else
       { 
           System.out.println("I'm sorry you aren't eligable for a bonus.");
       }

    }
    
    public static double bonusCalculator(int salary)
    {
        double bonusPercentage = .05;
        
        return (salary * bonusPercentage);
    }
}