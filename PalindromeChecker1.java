import java.util.Scanner;

public class PalindromeChecker1 {

    public static void main(String[] args) {
        // Take input from the user
        String input = getInput();
        
        // Check if the string is a palindrome
        if (isPalindrome(input)) {
            displayResult(input, true);
        } else {
            displayResult(input, false);
        }
    }

    // Function to get user input
    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        return scanner.nextLine();
    }

    // Function to check if the string is a palindrome
    public static boolean isPalindrome(String input) {
        // Remove non-alphanumeric characters and convert to lower case
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        // Check if the string equals its reverse
        String reversed = new StringBuilder(cleanedInput).reverse().toString();
        return cleanedInput.equals(reversed);
    }

    // Function to display the result
    public static void displayResult(String input, boolean isPalindrome) {
        if (isPalindrome) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is not a palindrome.");
        }
    }
}
