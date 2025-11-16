import java.util.Scanner;

public class FutureInvestmentValue {

    private static final int YEARS = 30;

    // Method that calculates the future investment value
    public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
        return investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12);
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {

            // Inputs
            System.out.print("Investment amount: ");
            double investmentAmount = input.nextDouble();

            System.out.print("Annual interest rate: ");
            double annualInterestRate = input.nextDouble();

            // Convert to monthly rate
            double monthlyInterestRate = annualInterestRate / 12;

            // Table header
            System.out.println("\nYears\tFuture Value");

            // Loop through years
            for (int i = 1; i <= YEARS; i++) {
                double futureValue = futureInvestmentValue(investmentAmount, monthlyInterestRate, i);
                System.out.printf("%d\t%.2f%n", i, futureValue);
            }
        }
    }
}

