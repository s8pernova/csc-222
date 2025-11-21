import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SpellChecker {
    public static void main(String[] args) {
        // Read words from dictionary file
        ArrayList<String> words = new ArrayList<>();
        String filePath = "/home/achrunaway/git-projects/csc-222/in-class-10/dict10.txt";
        File file = new File(filePath);
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String word = fileScanner.nextLine().trim();
                if (!word.isEmpty()) {
                    words.add(word.toLowerCase());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Dictionary file not found: " + filePath);
            return;
        }
        
        // Main search loop
        Scanner inputScanner = new Scanner(System.in);
        boolean flag = true;
        
        while (flag) {
            System.out.print("Search for: ");
            String userWord = inputScanner.nextLine().toLowerCase();
            
            if (userWord.equals("stop")) {
                flag = false;
            } else {
                int index = words.indexOf(userWord);
                if (index != -1) {
                    System.out.println("`" + userWord + "' was found in position " + (index + 1));
                } else {
                    System.out.println("Sorry, `" + userWord + "' was not found");
                }
            }
            System.out.println();
        }
        
        System.out.println("Bye!");
        inputScanner.close();
    }
}
