// F -> C
// Author: Aidan Hoo
// Date: 9/6/25

import java.util.Scanner;

public class tempConversion {
    public static void main(String[] args) {
        // Initialize scanner
        Scanner keyboard = new Scanner(System.in);

        // Input
        System.out.println("Enter the temperature in Fahrenheit: ");
        double fahrenheit = keyboard.nextDouble();
        
        // Process
        double celsius = Math.round((fahrenheit - 32) * 5 / 9 * 10.0) / 10.0;
        
        // Output
        System.out.println("The temperature in Celsius is " + celsius);
        
        // Close the Scanner
        keyboard.close();
    }
}