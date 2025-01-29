import java.util.Scanner;

public class BasicCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for two numbers
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        // Display the operations menu
        System.out.println("\nChoose an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");

        // Take user's choice
        System.out.print("\nEnter the operation number (1/2/3/4): ");
        int choice = scanner.nextInt();

        double result = 0; // Variable to store the result

        // Perform the operation based on user choice
        switch (choice) {
            case 1:
                result = add(num1, num2);
                break;
            case 2:
                result = subtract(num1, num2);
                break;
            case 3:
                result = multiply(num1, num2);
                break;
            case 4:
                if (num2 != 0) {
                    result = divide(num1, num2);
                } else {
                    System.out.println("Error: Cannot divide by zero.");
                    return; // Exit the program if division by zero
                }
                break;
            default:
                System.out.println("Invalid choice! Please choose a valid operation.");
                return; // Exit the program if an invalid choice is entered
        }

        // Display the result
        System.out.println("\nThe result is: " + result);

        scanner.close();
    }

    // Function to perform addition
    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    // Function to perform subtraction
    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    // Function to perform multiplication
    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    // Function to perform division
    public static double divide(double num1, double num2) {
        return num1 / num2;
    }
}
