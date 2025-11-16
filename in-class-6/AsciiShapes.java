import java.util.*;

public class AsciiShapes {
    
    static class Draw {
        private final int shape;
        private final String character;
        private final int size;
        
        public Draw(Map<String, Object> inputDict) {
            this.shape = (int) inputDict.get("shape");
            this.character = (String) inputDict.get("char");
            this.size = (int) inputDict.get("size");
        }
        
        public void triangle() {
            for (int i = 1; i <= size; i++) {
                System.out.println(" ".repeat(size - i) + character.repeat(2 * i - 1));
            }
        }
        
        public void diamond() {
            // Top half
            for (int i = 1; i <= size; i++) {
                System.out.println(" ".repeat(size - i) + character.repeat(2 * i - 1));
            }
            // Bottom half
            for (int i = size - 1; i > 0; i--) {
                System.out.println(" ".repeat(size - i) + character.repeat(2 * i - 1));
            }
        }
    }
    
    private final Scanner scanner;
    
    public AsciiShapes() {
        this.scanner = new Scanner(System.in);
    }
    
    public void run() {
        Map<String, Object> userInput = getUserInputs();
        Draw draw = new Draw(userInput);
        
        if (draw.shape == 1) {
            draw.triangle();
        } else if (draw.shape == 2) {
            draw.diamond();
        }
    }
    
    private Map<String, Object> getUserInputs() {
        Map<String, Object> inputDict = new HashMap<>();
        
        // Choose shape
        List<Integer> validInputs = Arrays.asList(1, 2, 3);
        System.out.print("Select a shape:\n1) Triangle\n2) Diamond\n3) Exit\n\n");
        int shape = Integer.parseInt(scanner.nextLine());
        if (shape == 3) {
            System.exit(0);
        } else if (!validInputs.contains(shape)) {
            throw new IllegalArgumentException();
        }
        inputDict.put("shape", shape);
        
        // Choose character
        System.out.print("\nSelect a character: ");
        String character = scanner.nextLine();
        if (character.length() != 1) {
            throw new IllegalArgumentException();
        }
        inputDict.put("char", character);
        
        // Choose size
        System.out.print("\nSelect a size: ");
        int size = Integer.parseInt(scanner.nextLine());
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        inputDict.put("size", size);
        
        return inputDict;
    }
    
    public static void main(String[] args) {
        new AsciiShapes().run();
    }
}