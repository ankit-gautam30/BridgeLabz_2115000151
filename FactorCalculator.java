import java.util.Scanner;

public class FactorCalculator {

    // Method to find the factors of a number and return them as an array
    public static int[] findFactors(int number) {
        // Step 1: Count the number of factors
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        // Step 2: Store factors into an array
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    // Method to calculate the sum of the factors
    public static int calculateSum(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    // Method to calculate the product of the factors
    public static long calculateProduct(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    // Method to calculate the sum of squares of the factors
    public static int calculateSumOfSquares(int[] factors) {
        int sumOfSquares = 0;
        for (int factor : factors) {
            sumOfSquares += Math.pow(factor, 2);
        }
        return sumOfSquares;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Find factors of the number
        int[] factors = findFactors(number);

        // Display the factors
        System.out.print("Factors: ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        System.out.println();

        // Calculate and display the sum of factors
        int sum = calculateSum(factors);
        System.out.println("Sum of factors: " + sum);

        // Calculate and display the product of factors
        long product = calculateProduct(factors);
        System.out.println("Product of factors: " + product);

        // Calculate and display the sum of squares of factors
        int sumOfSquares = calculateSumOfSquares(factors);
        System.out.println("Sum of squares of factors: " + sumOfSquares);

        scanner.close();
    }
}
