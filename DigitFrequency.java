import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (number < 0) {
            System.out.println("Error: Please enter a non-negative number.");
            return;
        }

        // Convert the number to a string to find the digits
        String numStr = Integer.toString(number);
        int[] digitFrequency = new int[10]; // Array to store frequency of each digit (0-9)

        // Loop through each character in the number string
        for (char digitChar : numStr.toCharArray()) {
            int digit = Character.getNumericValue(digitChar); // Convert character to integer
            digitFrequency[digit]++; // Increment the frequency of the digit
        }

        // Display the frequency of each digit
        System.out.println("Digit Frequency:");
        for (int i = 0; i < digitFrequency.length; i++) {
            if (digitFrequency[i] > 0) {
                System.out.println("Digit " + i + ": " + digitFrequency[i]);
            }
        }

        scanner.close();
    }
}
