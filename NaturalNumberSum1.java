import java.util.Scanner;

public class NaturalNumberSum1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a natural number (n): ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a valid natural number (greater than 0).");
        } else {
            int sumUsingLoop = 0;

            // Using a for loop to calculate the sum
            for (int i = 1; i <= n; i++) {
                sumUsingLoop += i;
            }

            int sumUsingFormula = n * (n + 1) / 2;

            System.out.println("Sum using formula: " + sumUsingFormula);
            System.out.println("Sum using for loop: " + sumUsingLoop);

            if (sumUsingLoop == sumUsingFormula) {
                System.out.println("Both computations are correct!");
            } else {
                System.out.println("There is a mismatch in the computations.");
            }
        }

        scanner.close();
    }
}
