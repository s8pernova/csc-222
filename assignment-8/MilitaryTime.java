import java.util.Scanner;

class InvalidTimeException extends Exception {
    public InvalidTimeException(String message) {
        super(message);
    }
}

class Times {
    final private int year;
    final private int month;
    final private int day;
    private int hour;
    private int minute;
    private int second;
    
    public Times(int year, int month, int day, int hour, int minute, int second) throws InvalidTimeException {
        this.year = year;
        this.month = month;
        this.day = day;
        
        // Validate time components
        if (hour < 0 || hour > 23) {
            throw new InvalidTimeException("Invalid hour: " + hour + ". Must be between 0 and 23.");
        }
        if (minute < 0 || minute > 59) {
            throw new InvalidTimeException("Invalid minute: " + minute + ". Must be between 0 and 59.");
        }
        if (second < 0 || second > 59) {
            throw new InvalidTimeException("Invalid second: " + second + ". Must be between 0 and 59.");
        }
        
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    
    public void printStandardTime() {
        int hour12 = hour % 12;
        if (hour12 == 0) {
            hour12 = 12;
        }
        String amPm = (hour < 12) ? "AM" : "PM";
        
        System.out.printf("Based on your entry, the Standard time is %d-%d-%d, %d:%02d:%02d %s%n",
                          month, day, year, hour12, minute, second, amPm);
    }
    
    public void printMilitaryTime() {
        System.out.printf("Based on your entry, the Military time is %d-%d-%d, %02d:%02d:%02d%n",
                          day, month, year, hour, minute, second);
    }
}

public class MilitaryTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter year: ");
            int year = scanner.nextInt();
            
            System.out.print("Enter month: ");
            int month = scanner.nextInt();
            
            System.out.print("Enter day: ");
            int day = scanner.nextInt();
            
            System.out.print("Enter hour: ");
            int hour = scanner.nextInt();
            
            System.out.print("Enter minute: ");
            int minute = scanner.nextInt();
            
            System.out.print("Enter second: ");
            int second = scanner.nextInt();
            
            Times time = new Times(year, month, day, hour, minute, second);
            time.printStandardTime();
            time.printMilitaryTime();
            
        } catch (InvalidTimeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input.");
        } finally {
            scanner.close();
        }
    }
}