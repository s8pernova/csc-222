// C -> F
// Author: Aidan Hoo
// Date: 9/7/25

import java.util.Scanner;

public class reverseTempConversion {
    public static void main(String[] args) {
        // Initialize scanner
        Scanner keyboard = new Scanner(System.in);

        // Input
        System.out.println("Enter the temperature in Celsius: ");
        double celsius = keyboard.nextDouble();

        // Process
        double fahrenheit = Math.round((celsius * (9.0 / 5.0) + 32) * 10.0) / 10.0;
        
        // Output
        System.out.println("The temperature in fahrenheit is " + fahrenheit);
        
        // Close the Scanner
        keyboard.close();
    }
}