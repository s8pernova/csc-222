
import java.util.Scanner;

public class MilesToYards {
    public static final int YARDS_IN_MILE = 1760;
    
    public static void main(String[] args) {
        // Close keyboard when done
        try (Scanner keyboard = new Scanner(System.in)) {

            System.out.print("Enter number of miles: ");
            double distance = keyboard.nextDouble();

            System.out.print("Enter number of yards: ");
            double yards = keyboard.nextDouble();
            
            double yardsFromMiles = distance * YARDS_IN_MILE;
            double totalSteps = yards + yardsFromMiles;
            
            System.out.println("The distance in steps is " + (int) totalSteps);
        }
    }
}
