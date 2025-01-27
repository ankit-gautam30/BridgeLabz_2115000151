import java.util.Scanner;

public class QuotientAndRemainder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for the number and divisor
        System.out.print("Enter the dividend (number): ");
        int number = scanner.nextInt();
        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        // Find the quotient and remainder
        int[] result = findRemainderAndQuotient(number, divisor);

        // Display the results
        System.out.println("The quotient is: " + result[0]);
        System.out.println("The remainder is: " + result[1]);

        scanner.close();
    }

    // Method to find the quotient and remainder
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;  // Division for quotient
        int remainder = number % divisor; // Modulus for remainder

        // Return quotient and remainder in an array
        return new int[] { quotient, remainder };
    }
}
