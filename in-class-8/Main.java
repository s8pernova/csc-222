import java.util.Scanner;

class Time {
    // Data fields
    private int hour;
    private int minute;
    private int second;
    
    public void input() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter hour: ");
        hour = scanner.nextInt();
        
        System.out.print("Enter minute: ");
        minute = scanner.nextInt();
        
        System.out.print("Enter second: ");
        second = scanner.nextInt();
    }
    
    public void print() {
        System.out.printf("Time: %02d:%02d:%02d%n", hour, minute, second);
    }
}

class Fraction {
    // Data fields
    private int numerator;
    private int denominator;
    
    // Two argument constructor
    public Fraction(int num, int denom) {
        if (denom == 0) {
            System.out.println("Error: Denominator cannot be zero. Setting to 1.");
            denom = 1;
        }
        this.numerator = num;
        this.denominator = denom;
    }
    
    // Mutator for numerator
    public void setNumerator(int num) {
        this.numerator = num;
    }
    
    // Mutator for denominator
    public void setDenominator(int denom) {
        if (denom == 0) {
            System.out.println("Error: Denominator cannot be zero. Value not changed.");
            return;
        }
        this.denominator = denom;
    }
    
    public void output() {
        System.out.println(numerator + "/" + denominator);
    }
    
    // Method to calculate and return percentage
    public double getPercentage() {
        return ((double) numerator / denominator) * 100;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("~~~~~~~~~~ TESTING TIME CLASS ~~~~~~~~~~");
        Times time1 = new Times();
        
        System.out.println("\nEnter time information:");
        time1.input();
        
        System.out.println("\nDisplaying the time:");
        time1.print();
        
        // Testing with another Time object
        System.out.println("\n\nCreating another Time object:");
        Times time2 = new Times();
        time2.input();
        System.out.println("\nDisplaying the second time:");
        time2.print();
        
        System.out.println("\n\n~~~~~~~~~~ TESTING FRACTION CLASS ~~~~~~~~~~");
        
        // Testing constructor
        System.out.println("\nCreating fraction 3/4:");
        Fraction frac1 = new Fraction(3, 4);
        System.out.print("Fraction 1: ");
        frac1.output();
        System.out.printf("Percentage: %.2f%%%n", frac1.getPercentage());
        
        // Testing another fraction
        System.out.println("\nCreating fraction 1/2:");
        Fraction frac2 = new Fraction(1, 2);
        System.out.print("Fraction 2: ");
        frac2.output();
        System.out.printf("Percentage: %.2f%%%n", frac2.getPercentage());
        
        // Testing mutators
        System.out.println("\n--- Testing Mutator Methods ---");
        System.out.println("Changing Fraction 2 to 5/8:");
        frac2.setNumerator(5);
        frac2.setDenominator(8);
        System.out.print("Updated Fraction 2: ");
        frac2.output();
        System.out.printf("Percentage: %.2f%%%n", frac2.getPercentage());
        
        // Testing with user input
        System.out.println("\n--- Creating Fraction from User Input ---");
        System.out.print("Enter numerator: ");
        int num = scanner.nextInt();
        System.out.print("Enter denominator: ");
        int denom = scanner.nextInt();
        
        Fraction frac3 = new Fraction(num, denom);
        System.out.print("Your fraction: ");
        frac3.output();
        System.out.printf("Percentage: %.2f%%%n", frac3.getPercentage());
        
        // Testing edge case (denominator = 0)
        System.out.println("\n--- Testing Error Handling ---");
        System.out.println("Attempting to create fraction with denominator 0:");
        Fraction frac4 = new Fraction(5, 0);
        System.out.print("Result: ");
        frac4.output();
        
        System.out.println("\n~~~~~~~~~~ ALL TESTS COMPLETED ~~~~~~~~~~");
        
        scanner.close();
    }
}