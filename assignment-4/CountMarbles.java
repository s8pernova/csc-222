/* 
Program to count red, yellow, and blue marbles.
The user will abbreviate the colors with a single letter, as follows:

r = red
y = yellow
b = blue
q = quit

Continually ask the user for the color of a marble, until 'q' (for quit) is entered. 
Then, display the number of marbles of each color as well as the total number of marbles.
Use appropriate messages for all output.

If a letter other than those listed above is entered, display a warning message and ignore that entry (but continue the program).

Announce the name of the `winning' color (the color with the greatest number of marbles).
Break ties arbitrarily, but don't display more than one winner. 
*/

import java.util.*;

public class CountMarbles {
    public static void main(String[] args) {
        try (Scanner keyboard = new Scanner(System.in)) {
            // Learning how to use mapping
            Map<String, Integer> colors = new HashMap<>();

            colors.put("red", 0);
            colors.put("yellow", 0);
            colors.put("blue", 0);

            while (true) {
                System.out.print("Enter color (r, y, b, or q to quit): ");
                String input = (
                    keyboard.nextLine()  // Get input
                            .trim()  // Remove whitespace (just in case)
                            .toLowerCase()  // Convert to lowercase
                );

                if (input.equals("q")) break;

                switch (input) {
                    case "r":
                        colors.put("red", colors.get("red") + 1);
                        break;
                    case "y":
                        colors.put("yellow", colors.get("yellow") + 1);
                        break;
                    case "b":
                        colors.put("blue", colors.get("blue") + 1);
                        break;
                    default:
                        System.out.println("Invalid input. Please enter r, y, b, or q.");
                }
            }

            int total = (
                colors.values()  // Get values
                        .stream()  // Convert to stream
                        .mapToInt(Integer::intValue)  // Convert to int
                        .sum()  // Sum
            );
            
            // Ternary for loop to print all results
            System.out.println("\nResults:");
            colors.forEach((color, count) -> System.out.println(color + " marbles: " + count));
            System.out.println("\nTotal marbles: " + total);

            String winner = Collections.max(colors.entrySet(), Map.Entry.comparingByValue()).getKey();
            System.out.println("\nWinning color: " + winner);
        }
    }
}
