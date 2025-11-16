import java.util.Scanner;
public class Asterisk {
    public static void main(String[] args) {
        try (Scanner keyboard = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            double user_input = keyboard.nextDouble();
            for (int i = 1; i <= user_input; i++) {
                System.out.println(String.valueOf("*").repeat((int) (2 * i - 1)));
            }
        }
    }
}
