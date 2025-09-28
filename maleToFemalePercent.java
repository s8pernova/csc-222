// Excercise for csc 222
// Author: Aidan Hoo
// 9/13/25

import java.util.*;

public class maleToFemalePercent {
    public static void main(String[] args) {
        // input
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the number of male students: ");
        int maleNumber = keyboard.nextInt();
        
        System.out.print("Enter the number of female students: ");
        int femaleNumber = keyboard.nextInt();

        // process
        double malePercent = (double) maleNumber / (maleNumber + femaleNumber);
        double femalePercent = (double) femaleNumber / (femaleNumber + maleNumber);

        // close keyboard
        keyboard.close();

        // output
        System.out.printf("Male percentage: %.0f%%\nFemale percentage: %.0f%%\n", malePercent * 100, femalePercent * 100);
    }   
}
