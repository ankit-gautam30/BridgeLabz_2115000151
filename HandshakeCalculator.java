import java.util.Scanner;

public class HandshakeCalculator {

    // Method to calculate the maximum number of handshakes
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Input the number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        // Validate input
        if (numberOfStudents < 2) {
            System.out.println("The number of students should be at least 2 to have handshakes.");
        } else {
            // Calculate the maximum number of handshakes
            int maxHandshakes = calculateHandshakes(numberOfStudents);

            // Output the result
            System.out.printf("The maximum number of handshakes among %d students is %d.%n", 
                              numberOfStudents, maxHandshakes);
        }

        // Close the scanner
        scanner.close();
    }
}
