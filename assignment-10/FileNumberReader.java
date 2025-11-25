import java.io.*;
import java.util.Scanner;

public class FileNumberReader {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        // Prompt user for count
        System.out.print("How many numbers do you want to read? ");
        int count = keyboard.nextInt();
        
        try {
            // Read from data.txt
            File inputFile = new File("data.txt");
            Scanner fileReader = new Scanner(inputFile);
            
            // Store numbers and calculate sum
            double[] numbers = new double[count];
            double sum = 0;
            
            for (int i = 0; i < count && fileReader.hasNextDouble(); i++) {
                numbers[i] = fileReader.nextDouble();
                sum += numbers[i];
            }
            
            fileReader.close();
            
            // Display output on screen
            System.out.println("The numbers are:");
            for (int i = 0; i < count; i++) {
                System.out.println((int)numbers[i]);
            }
            System.out.println("The total is: " + (int)sum);
            
            // Write to result.txt
            PrintWriter writer = new PrintWriter("result.txt");
            writer.println("The numbers are:");
            for (int i = 0; i < count; i++) {
                writer.println((int)numbers[i]);
            }
            writer.println("The total is: " + (int)sum);
            writer.close();
            
            System.out.println("\nResult has been saved to result.txt");
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: data.txt file not found!");
        } finally {
            keyboard.close();
        }
    }
}