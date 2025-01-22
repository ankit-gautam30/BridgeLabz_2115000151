import java.util.Scanner;

public class RoundsFor5KmRun {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking user inputs for the sides of the triangle
        System.out.print("Enter side 1 of the triangle in meters: ");
        double side1 = input.nextDouble();

        System.out.print("Enter side 2 of the triangle in meters: ");
        double side2 = input.nextDouble();

        System.out.print("Enter side 3 of the triangle in meters: ");
        double side3 = input.nextDouble();

        // Calculating the perimeter of the triangle
        double perimeter = side1 + side2 + side3;

        // Distance to run is 5 km, which is 5000 meters
        double totalDistance = 5000;  // 5 km = 5000 meters

        // Calculating the number of rounds
        double rounds = totalDistance / perimeter;

        System.out.println("The total number of rounds the athlete will run is " + rounds);
    }
}
