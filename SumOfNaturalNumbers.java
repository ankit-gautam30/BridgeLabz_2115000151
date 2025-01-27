import java.util.Scanner;

public class SumOfNaturalNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get integer input from the user
        System.out.print("Enter a positive integer n: ");
        int n = scanner.nextInt();

        // Validate input (ensure the user provides a positive integer)
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            // Call the method to calculate the sum
            int sum = sumOfNaturalNumbers(n);

            // Display the result
            System.out.println("The sum of the first " + n + " natural numbers is: " + sum);
        }

        scanner.close();
    }

    // Method to find the sum of the first n natural numbers using a loop
    public static int sumOfNaturalNumbers(int n) {
        int sum = 0;

        // Loop to calculate the sum of the first n natural numbers
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        return sum;
    }
}
