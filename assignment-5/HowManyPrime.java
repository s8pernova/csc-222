import java.util.Scanner;

public class HowManyPrime {
    private static boolean is_prime(int n) {
        for (int i = 2; i <= Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        try (Scanner keyboard = new Scanner(System.in)) {
            System.out.print("How many prime numbers do you want? ");
            int user_input = keyboard.nextInt();

            System.out.println("\nThe first " + user_input + " prime numbers are:");
            int count = 1;
            for (int i = 2; count - 1 < user_input; i++) {
                if (is_prime(i)) {
                    // Get the ordinal
                    int last_digit = count % 10;
                    String ordinal = last_digit == 1 ? "st" : last_digit == 2 ? "nd" : last_digit == 3 ? "rd" : "th";

                    System.out.println("The " + count + ordinal + " prime number is " + i);
                    count++;
                }
            }
        }
    }
}