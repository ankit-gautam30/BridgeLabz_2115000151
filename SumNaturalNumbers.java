import java.util.Scanner;

public class SumNaturalNumbers {

    // Recursive method to calculate the sum of n natural numbers
    public static int sumRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumRecursive(n - 1);
    }

    // Method to calculate the sum of n natural numbers using the formula
    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        // Check if the number is a natural number (positive integer)
        if (n <= 0) {
            System.out.println("The input is not a natural number. Please enter a positive integer.");
            scanner.close();
            return;
        }

        // Calculate the sum using recursion
        int sumFromRecursion = sumRecursive(n);

        // Calculate the sum using the formula
        int sumFromFormula = sumFormula(n);

        // Compare and display the results
        System.out.println("Sum using recursion: " + sumFromRecursion);
        System.out.println("Sum using formula: " + sumFromFormula);

        if (sumFromRecursion == sumFromFormula) {
            System.out.println("The results from both computations match and are correct.");
        } else {
            System.out.println("The results do not match. Please check the implementation.");
        }

        scanner.close();
    }
}
