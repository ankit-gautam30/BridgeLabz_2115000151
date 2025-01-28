import java.util.Arrays;

public class NumberChecker4 {

    // Method to find the count of digits in a number
    public static int countDigits(int number) {
        return Integer.toString(number).length();
    }

    // Method to store the digits of a number in a digits array
    public static int[] storeDigits(int number) {
        int numDigits = countDigits(number);
        int[] digits = new int[numDigits];

        for (int i = numDigits - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }

        return digits;
    }

    // Method to reverse the digits array
    public static int[] reverseArray(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    // Method to compare two arrays and check if they are equal
    public static boolean areArraysEqual(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    // Method to check if a number is a palindrome using the digits
    public static boolean isPalindrome(int number) {
        int[] digits = storeDigits(number);
        int[] reversed = reverseArray(digits);

        return areArraysEqual(digits, reversed);
    }

    // Method to check if a number is a duck number using the digits array
    public static boolean isDuckNumber(int number) {
        int[] digits = storeDigits(number);

        // A duck number must contain at least one zero but cannot start with zero
        if (digits[0] == 0) {
            return false;
        }

        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Example number for testing
        int number = 12321;

        // Find and display the count of digits
        System.out.println("Count of digits: " + countDigits(number));

        // Store and display the digits of the number
        int[] digits = storeDigits(number);
        System.out.println("Digits of the number: " + Arrays.toString(digits));

        // Reverse and display the digits array
        int[] reversedDigits = reverseArray(digits);
        System.out.println("Reversed digits: " + Arrays.toString(reversedDigits));

        // Check and display if the number is a palindrome
        System.out.println("Is Palindrome: " + isPalindrome(number));

        // Check and display if the number is a duck number
        System.out.println("Is Duck Number: " + isDuckNumber(number));
    }
}
