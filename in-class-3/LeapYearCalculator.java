import java.util.Scanner;

// Trying to use branchless programming but failed because .compare uses an if statement
public class LeapYearCalculator {
    public static void main(String[] args) {
        try (Scanner keyboard = new Scanner(System.in)) {
            System.out.print("Enter a year: ");

            int year = keyboard.nextInt();
            boolean isLeapYear = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
            
            String[] years = {"not a leap year", "a leap year"};

            int index = Boolean.compare(isLeapYear, false);
            
            System.out.println(year + " is " + years[index]);
        } 
    }
}
