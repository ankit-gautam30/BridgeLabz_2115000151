import java.util.Arrays;

public class NumberChecker6 {

    // Method to find factors of a number and return them as an array
    public static int[] findFactors(int number) {
        int count = 0;

        // First loop to count the number of factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        // Second loop to store the factors in an array
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }

        return factors;
    }

    // Method to find the greatest factor of a number using the factors array
    public static int findGreatestFactor(int[] factors) {
        return factors[factors.length - 2]; // The largest factor is the number itself; second last is greatest proper factor.
    }

    // Method to find the sum of the factors using the factors array
    public static int findSumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    // Method to find the product of the factors using the factors array
    public static int findProductOfFactors(int[] factors) {
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    // Method to find the product of the cube of the factors using the factors array
    public static double findProductOfCubeOfFactors(int[] factors) {
        double product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
    }

    // Method to check if a number is a perfect number
    public static boolean isPerfectNumber(int number) {
        int[] factors = findFactors(number);
        int sum = findSumOfFactors(factors) - number; // Exclude the number itself
        return sum == number;
    }

    // Method to check if a number is an abundant number
    public static boolean isAbundantNumber(int number) {
        int[] factors = findFactors(number);
        int sum = findSumOfFactors(factors) - number; // Exclude the number itself
        return sum > number;
    }

    // Method to check if a number is a deficient number
    public static boolean isDeficientNumber(int number) {
        int[] factors = findFactors(number);
        int sum = findSumOfFactors(factors) - number; // Exclude the number itself
        return sum < number;
    }

    // Method to check if a number is a strong number
    public static boolean isStrongNumber(int number) {
        int originalNumber = number;
        int sumOfFactorials = 0;

        while (number > 0) {
            int digit = number % 10;
            sumOfFactorials += factorial(digit);
            number /= 10;
        }

        return sumOfFactorials == originalNumber;
    }

    // Helper method to calculate the factorial of a number
    public static int factorial(int num) {
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int number = 28;

        // Find and display the factors of the number
        int[] factors = findFactors(number);
        System.out.println("Factors: " + Arrays.toString(factors));

        // Find and display the greatest factor
        System.out.println("Greatest Proper Factor: " + findGreatestFactor(factors));

        // Find and display the sum of factors
        System.out.println("Sum of Factors: " + findSumOfFactors(factors));

        // Find and display the product of factors
        System.out.println("Product of Factors: " + findProductOfFactors(factors));

        // Find and display the product of the cube of factors
        System.out.println("Product of Cube of Factors: " + findProductOfCubeOfFactors(factors));

        // Check and display if the number is a perfect number
        System.out.println("Is Perfect Number: " + isPerfectNumber(number));

        // Check and display if the number is an abundant number
        System.out.println("Is Abundant Number: " + isAbundantNumber(number));

        // Check and display if the number is a deficient number
        System.out.println("Is Deficient Number: " + isDeficientNumber(number));

        // Check and display if the number is a strong number
        System.out.println("Is Strong Number: " + isStrongNumber(number));
    }
}
