import java.util.Scanner;

public class AthleteRoundCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for the three sides of the triangular park
        System.out.print("Enter the length of the first side (in meters): ");
        double side1 = scanner.nextDouble();
        System.out.print("Enter the length of the second side (in meters): ");
        double side2 = scanner.nextDouble();
        System.out.print("Enter the length of the third side (in meters): ");
        double side3 = scanner.nextDouble();

        // Calculate the number of rounds needed
        int rounds = calculateRounds(side1, side2, side3);

        // Display the result
        System.out.println("The athlete needs to complete " + rounds + " rounds to run 5 km.");

        scanner.close();
    }

    // Method to calculate the number of rounds
    public static int calculateRounds(double side1, double side2, double side3) {
        // Calculate the perimeter of the triangle
        double perimeter = side1 + side2 + side3;

        // Total distance to be run in meters (5 km = 5000 meters)
        double totalDistance = 5000;

        // Calculate the number of rounds (ceil to ensure full completion of the distance)
        int rounds = (int) Math.ceil(totalDistance / perimeter);

        return rounds;
    }
}
