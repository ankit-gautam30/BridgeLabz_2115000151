import java.util.Scanner;

public class FactorialUsingRecursion {

    public static void main(String[] args) {
        // Take input from the user
        int number = getInput();
        
        // Calculate the factorial using recursion
        long factorial = calculateFactorial(number);
        
        // Display the result
        displayResult(number, factorial);
    }

    // Function to get user input
    public static int getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to calculate its factorial: ");
        return scanner.nextInt();
    }

    // Recursive function to calculate the factorial of a number
    public static long calculateFactorial(int number) {
        if (number == 0 || number == 1) {
            return 1; // Base case: factorial of 0 or 1 is 1
        } else {
            return number * calculateFactorial(number - 1); // Recursive call
        }
    }

    // Function to display the result
    public static void displayResult(int number, long factorial) {
        System.out.println("The factorial of " + number + " is: " + factorial);
    }
}
