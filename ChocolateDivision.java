import java.util.Scanner;

public class ChocolateDivision {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input for the number of chocolates and number of children
        System.out.print("Enter the total number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();

        System.out.print("Enter the total number of children: ");
        int numberOfChildren = scanner.nextInt();

        // Check for valid divisor
        if (numberOfChildren == 0) {
            System.out.println("Number of children cannot be zero. Division is not possible.");
        } else {
            // Calculate the quotient and remainder
            int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

            // Display the results
            System.out.println("Each child will get " + result[0] + " chocolates.");
            System.out.println("The remaining chocolates are: " + result[1]);
        }

        scanner.close();
    }

    // Method to find the quotient and remainder
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;  // Chocolates each child gets
        int remainder = number % divisor; // Remaining chocolates

        // Return quotient and remainder as an array
        return new int[] { quotient, remainder };
    }
}
