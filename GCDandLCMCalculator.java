import java.util.Scanner;

public class GCDandLCMCalculator {

    public static void main(String[] args) {
        // Take user input for two numbers
        int num1 = getInput("Enter the first number: ");
        int num2 = getInput("Enter the second number: ");
        
        // Calculate GCD
        int gcd = calculateGCD(num1, num2);
        
        // Calculate LCM
        int lcm = calculateLCM(num1, num2, gcd);
        
        // Display the results
        displayResults(gcd, lcm);
    }

    // Function to get input from the user
    public static int getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }

    // Function to calculate the GCD using Euclidean algorithm
    public static int calculateGCD(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    // Function to calculate the LCM using the relationship between GCD and LCM
    public static int calculateLCM(int num1, int num2, int gcd) {
        return (num1 * num2) / gcd;
    }

    // Function to display the results
    public static void displayResults(int gcd, int lcm) {
        System.out.println("The GCD is: " + gcd);
        System.out.println("The LCM is: " + lcm);
    }
}
