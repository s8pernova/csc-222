import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Packages {
    public static final int PRICE_PER_PACKAGE = 99;
    
    // Map of discounts
    public static final NavigableMap<Integer, Double> DISCOUNTS = new TreeMap<>();
    static {
        DISCOUNTS.put(10, 0.10);
        DISCOUNTS.put(20, 0.20);
        DISCOUNTS.put(50, 0.30);
        DISCOUNTS.put(100, 0.40);
    }

    public static double getDiscount(int quantity) {
        Integer key = DISCOUNTS.floorKey(quantity);
        return (key != null) ? DISCOUNTS.get(key) : 0.0;
    }
    
    public static void main(String[] args) {
        try (Scanner keyboard = new Scanner(System.in)) {

            System.out.print("Enter the number of packages: ");
            int packages = keyboard.nextInt();

            double discount = getDiscount(packages);
            double priceOfDiscount = packages * PRICE_PER_PACKAGE * discount;
            System.out.printf("Discount: $%.2f\n", priceOfDiscount);

            double total = (packages * PRICE_PER_PACKAGE) * (1 - discount);
            System.out.printf("Total amount after discount: $%.2f%n", total);
        }
    }
}
