import java.util.Scanner;
public class Area
{
    public static void main(String[] args) 
    {
        //initialize variables
        int radiusInput;
        double pi = Math.PI;
        
        //create scanner object
        Scanner s = new Scanner(System.in);
        
        //user input
        System.out.println("Please enter the radius of your circle:");
        radiusInput = s.nextInt();
        
        //calculate area
        double area = (Math.pow(radiusInput, 2) * pi);
        
        //display answer
        System.out.println("Area of circle:"+area);
    }
}