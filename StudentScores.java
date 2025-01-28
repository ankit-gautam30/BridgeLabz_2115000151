import java.util.Random;
import java.util.Scanner;

public class StudentScores {

    // Method to generate random 2-digit scores for Physics, Chemistry, and Maths for each student
    public static int[][] generateRandomScores(int numStudents) {
        Random random = new Random();
        int[][] scores = new int[numStudents][3]; // [][0] = Physics, [][1] = Chemistry, [][2] = Maths

        for (int i = 0; i < numStudents; i++) {
            // Generate random scores between 10 and 99 (2-digit scores)
            scores[i][0] = 10 + random.nextInt(90); // Physics score
            scores[i][1] = 10 + random.nextInt(90); // Chemistry score
            scores[i][2] = 10 + random.nextInt(90); // Maths score
        }

        return scores;
    }

    // Method to calculate the total, average, and percentage for each student
    public static double[][] calculateScores(int[][] scores) {
        double[][] results = new double[scores.length][4]; // [][0] = total, [][1] = average, [][2] = percentage

        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            // Store the results (rounded to 2 decimal places)
            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }

        return results;
    }

    // Method to display the scorecard of all students
    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.println("---------------------------------------------------------------");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |\n", "Student", "Physics", "Chemistry", "Maths", "Total", "Percentage");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            int physics = scores[i][0];
            int chemistry = scores[i][1];
            int maths = scores[i][2];
            double total = results[i][0];
            double average = results[i][1];
            double percentage = results[i][2];

            System.out.printf("| %-10d | %-10d | %-10d | %-10d | %-10.2f | %-10.2f |\n", (i + 1), physics, chemistry, maths, total, percentage);
        }

        System.out.println("---------------------------------------------------------------");
    }

    public static void main(String[] args) {
        // Take the number of students as input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        // Step 1: Generate random scores for Physics, Chemistry, and Maths for each student
        int[][] scores = generateRandomScores(numStudents);

        // Step 2: Calculate total, average, and percentage for each student
        double[][] results = calculateScores(scores);

        // Step 3: Display the scorecard
        displayScorecard(scores, results);
    }
}
