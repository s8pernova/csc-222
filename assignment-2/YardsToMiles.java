import java.util.Scanner;

public class YardsToMiles {
    public static final int YARDS_IN_MILE = 1760;
    
    public static void main(String[] args) {
        // Close keyboard when done
        try (Scanner keyboard = new Scanner(System.in)) {
            
            System.out.print("Enter number of steps: ");
            double yards = keyboard.nextDouble();
            
            double miles = yards / YARDS_IN_MILE;
            double remainder = yards % YARDS_IN_MILE;
            
            System.out.println((int) yards + " steps = " + (int) miles + " miles, " + (int) remainder + " yards");
        }
    }
}
