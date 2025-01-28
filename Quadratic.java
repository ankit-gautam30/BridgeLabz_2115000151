import java.util.Scanner;

public class Quadratic {

    // Method to find the roots of a quadratic equation
    public static double[] findRoots(double a, double b, double c) {
        // Calculate delta (discriminant)
        double delta = Math.pow(b, 2) - 4 * a * c;

        if (delta > 0) {
            // Two real and distinct roots
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{root1, root2};
        } else if (delta == 0) {
            // One real root
            double root = -b / (2 * a);
            return new double[]{root};
        } else {
            // No real roots
            return new double[]{};
        }
    }

    public static void main(String[] args) {
        // Create a scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input values for a, b, and c
        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();

        // Find the roots using the findRoots method
        double[] roots = findRoots(a, b, c);

        // Display the results
        if (roots.length == 2) {
            System.out.println("The roots of the quadratic equation are: ");
            System.out.println("Root 1 = " + roots[0]);
            System.out.println("Root 2 = " + roots[1]);
        } else if (roots.length == 1) {
            System.out.println("There is one root: ");
            System.out.println("Root = " + roots[0]);
        } else {
            System.out.println("The equation has no real roots.");
        }

        scanner.close();
    }
}
