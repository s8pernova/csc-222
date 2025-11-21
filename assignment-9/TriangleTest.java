import java.util.Scanner;

// Custom exception class
class NotARealTriangleException extends Exception {
    public NotARealTriangleException(String message) {
        super(message);
    }
}

// Triangle class
class Triangle {
    private double side1;
    private double side2;
    private double side3;
    
    // Constructor
    public Triangle() {
        this.side1 = 0.0;
        this.side2 = 0.0;
        this.side3 = 0.0;
    }
    
    // Constructor with parameters
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    // Private helper method to check if sides form a valid triangle
    private boolean isRealTriangle() {
        return (side1 + side2 > side3) && 
               (side1 + side3 > side2) && 
               (side2 + side3 > side1);
    }
    
    // Input method to get triangle sides from user
    public void input() throws NotARealTriangleException {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Please enter the value for side 1: ");
        this.side1 = Math.round(scanner.nextDouble() * 100.0) / 100.0;
        
        System.out.print("Please enter the value for side 2: ");
        this.side2 = Math.round(scanner.nextDouble() * 100.0) / 100.0;
        
        System.out.print("Please enter the value for side 3: ");
        this.side3 = Math.round(scanner.nextDouble() * 100.0) / 100.0;
        
        System.out.println();
        
        if (!isRealTriangle()) {
            throw new NotARealTriangleException("The sides do not form a valid triangle!");
        }
    }
    
    // Method to calculate and return perimeter
    public double perimeter() {
        double perimeter = side1 + side2 + side3;
        return Math.round(perimeter * 100.0) / 100.0;
    }
    
    // Method to check if triangle is equilateral
    public boolean isEquilateral() {
        return (side1 == side2) && (side2 == side3);
    }
    
    // Method to calculate and return area using Heron's formula
    public double area() {
        double semiPerimeter = (side1 + side2 + side3) / 2.0;
        double area = Math.sqrt(semiPerimeter * 
                               (semiPerimeter - side1) * 
                               (semiPerimeter - side2) * 
                               (semiPerimeter - side3));
        return Math.round(area * 100.0) / 100.0;
    }
    
    // Output method to display triangle information
    public void output() {
        System.out.println("The three sides that you entered are: " + 
                          side1 + ", " + side2 + ", and " + side3);
        System.out.println("The perimeter of the triangle is: " + perimeter());
        
        if (isEquilateral()) {
            System.out.println("The triangle is equilateral.");
        } else {
            System.out.println("The triangle is NOT equilateral.");
        }
        
        System.out.println("The area of the triangle is: " + area());
    }
}

// Main class to test Triangle
public class TriangleTest {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        
        try {
            triangle.input();
            triangle.output();
        } catch (NotARealTriangleException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}