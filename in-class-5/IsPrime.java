import java.util.Scanner;

public class IsPrime {
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
            System.out.print("Enter a number: ");
            double user_input = keyboard.nextDouble();
            if (Math.abs(user_input) < 2) {
                System.out.println(user_input + " is neither prime nor composite");
            }
            else if (is_prime((int) user_input)) {
                System.out.println(user_input + " is a prime number");
            } else {
                System.out.println(user_input + " is not a prime number");
            }
        }
    }
}