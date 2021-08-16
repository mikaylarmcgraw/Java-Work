//Summary have user enter in three numbers and sort them in ascending and descending order
//Disregard input of duplicate integers

import java.util.Scanner;
public class IntegerSort
{
    public static void main (String args[]) 
    {
        int a;
        int b;
        int c;
        
        //creating scanner object
        Scanner userInput = new Scanner(System.in);
        
        //capturing user inputs
        System.out.println("Please enter first number:");
        a =userInput.nextInt();
        System.out.println("Please enter second number:");
        b =userInput.nextInt();
        System.out.println("Please enter third number:");
        c =userInput.nextInt();
        
        //creating array of inputs and indexes of max and min elements
        int intArray[] = {a,b,c};
        int maxElement = 0;
        int maxValue=0;
        int minElement = 0;
        int minValue=0;
        int middleElement = 0;
        int middleValue=0;
        
        //finding max value
        for (int i = 0; i < 3; i++)
        {
            if (intArray[maxElement] <= intArray[i])
            {
                maxElement = i;
                maxValue = intArray[i]; //storing the maximum value 
            }
        }
        
        //finding min value
        for (int i = 0; i < 3; i++)
        {
            if (intArray[minElement] >= intArray[i])
            {
                minElement = i;
                minValue = intArray[i]; //storing minimum value
            }
        }
        
        //finding middle element
        for (int i = 0; i < 3; i++)
        {
            if (intArray[i] < maxValue && intArray[i] > minValue)
            {
                middleElement = i;
                middleValue = intArray[i]; //storing middle value
            }           
        }
       
        //ascending order
        System.out.println("Ascending order of inputs: " + minValue +", " + middleValue + ", " + maxValue); 
        
        //descending order
        System.out.println("Descending order of inputs: " + maxValue +", " + middleValue + ", " + minValue); 
    }
}