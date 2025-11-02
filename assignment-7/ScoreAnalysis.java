import java.util.Scanner;

public class ScoreAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read number of scores
        System.out.print("How many scores? ");
        int slen = scanner.nextInt();
        
        // Create array to store scores
        double[] scores = new double[slen];
        
        // Read each score
        for (int i = 0; i < slen; i++) {
            System.out.print("Enter a score: ");
            scores[i] = scanner.nextDouble();
        }
        
        // Calculate average
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        double avg = sum / slen;
        
        // Find highest score
        double highest = scores[0];
        for (double score : scores) {
            if (score > highest) {
                highest = score;
            }
        }
        
        // Output average and highest score
        System.out.printf("The average score is %.2f%n", avg);
        System.out.printf("The highest score is %.2f%n", highest);
        
        // Output each score's difference from average
        for (double score : scores) {
            double difference = Math.abs(score - avg);
            
            if (score > avg) {
                System.out.printf("%.2f is above average by %.2f%n", score, difference);
            } else if (score < avg) {
                System.out.printf("%.2f is below average by %.2f%n", score, difference);
            } else {
                System.out.printf("%.2f is equivalent to the average%n", score);
            }
        }
        
        scanner.close();
    }
}