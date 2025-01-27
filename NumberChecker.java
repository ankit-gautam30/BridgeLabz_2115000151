import java.util.Scanner;

public class NumberChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get integer input from the user
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // Check whether the number is positive, negative, or zero
        int result = checkNumber(number);

        // Display the result
        if (result == 1) {
            System.out.println("The number is positive.");
        } else if (result == -1) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }

        scanner.close();
    }

    // Method to check whether the number is positive, negative, or zero
    public static int checkNumber(int number) {
        if (number > 0) {
            return 1; // Positive number
        } else if (number < 0) {
            return -1; // Negative number
        } else {
            return 0; // Zero
        }
    }
}
