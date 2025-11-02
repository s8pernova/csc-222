import java.util.Scanner;

public class ArrayMaxSort {
    
    // Find maximum element
    public static int max(int[] array) {
        int maximum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maximum) {
                maximum = array[i];
            }
        }
        return maximum;
    }
    
    // Sort array
    public static int[] sort(int[] list) {
        // Copy
        int[] sorted = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            sorted[i] = list[i];
        }
        
        for (int i = 0; i < sorted.length - 1; i++) {
            for (int j = 0; j < sorted.length - 1 - i; j++) {
                if (sorted[j] > sorted[j + 1]) {
                    // Swap
                    int temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        
        return sorted;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[10];
        
        System.out.println("Enter ten numbers: ");
        for (int i = 0; i < 10; i++) {
            numbers[i] = input.nextInt();
        }
        
        int maximum = max(numbers);
        System.out.println("The maximum number is: " + maximum);
        
        int[] sortedNumbers = sort(numbers);
        System.out.print("The sorted numbers: ");
        for (int i = 0; i < sortedNumbers.length; i++) {
            System.out.print(sortedNumbers[i]);
            if (i < sortedNumbers.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        
        input.close();
    }
}