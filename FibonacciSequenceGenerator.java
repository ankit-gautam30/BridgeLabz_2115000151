import java.util.Scanner;

public class FibonacciSequenceGenerator {

    public static void main(String[] args) {
        // Take user input for the number of terms in the Fibonacci sequence
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms in the Fibonacci sequence: ");
        int terms = scanner.nextInt();
        
        // Call the function to generate and print the Fibonacci sequence
        generateFibonacci(terms);
        
        scanner.close();
    }

    // Function to calculate and print the Fibonacci sequence up to the specified number of terms
    public static void generateFibonacci(int terms) {
        if (terms <= 0) {
            System.out.println("Please enter a positive number of terms.");
            return;
        }

        // Initialize the first two terms of the Fibonacci sequence
        int first = 0;
        int second = 1;

        System.out.println("Fibonacci Sequence up to " + terms + " terms:");
        
        for (int i = 1; i <= terms; i++) {
            System.out.print(first + " ");
            
            // Calculate the next term in the sequence
            int nextTerm = first + second;
            first = second;  // Move first to second
            second = nextTerm;  // Move second to next term
        }
    }
}
