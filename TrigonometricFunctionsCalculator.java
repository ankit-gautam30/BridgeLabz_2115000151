import java.util.Scanner;

public class TrigonometricFunctionsCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input for the angle in degrees
        System.out.print("Enter the angle in degrees: ");
        double angle = scanner.nextDouble();

        // Calculate trigonometric functions
        double[] results = calculateTrigonometricFunctions(angle);

        // Display the results
        System.out.printf("Sine of %.2f degrees: %.4f%n", angle, results[0]);
        System.out.printf("Cosine of %.2f degrees: %.4f%n", angle, results[1]);
        System.out.printf("Tangent of %.2f degrees: %.4f%n", angle, results[2]);

        scanner.close();
    }

    // Method to calculate sine, cosine, and tangent of an angle in degrees
    public static double[] calculateTrigonometricFunctions(double angle) {
        // Convert the angle to radians
        double radians = Math.toRadians(angle);

        // Calculate sine, cosine, and tangent
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);

        // Return the results as an array
        return new double[] { sine, cosine, tangent };
    }
}
