import java.util.Scanner;

public class TravelDetails {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking user inputs for names and cities
        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter the starting city: ");
        String fromCity = input.nextLine();

        System.out.print("Enter the via city: ");
        String viaCity = input.nextLine();

        System.out.print("Enter the destination city: ");
        String toCity = input.nextLine();

        // Taking user inputs for distances
        System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " in miles: ");
        double fromToVia = input.nextDouble();

        System.out.print("Enter the distance from " + viaCity + " to " + toCity + " in miles: ");
        double viaToFinalCity = input.nextDouble();

        // Taking user input for time taken
        System.out.print("Enter the time taken for the trip in hours: ");
        double timeTaken = input.nextDouble();

        // Calculating total distance and average speed
        double totalDistance = fromToVia + viaToFinalCity;
        double averageSpeed = totalDistance / timeTaken;

        // Printing the result
        System.out.println("\nTravel Details:");
        System.out.println("Name: " + name);
        System.out.println("Route: " + fromCity + " -> " + viaCity + " -> " + toCity);
        System.out.println("Total Distance: " + totalDistance + " miles");
        System.out.println("Time Taken: " + timeTaken + " hours");
        System.out.println("Average Speed: " + averageSpeed + " miles per hour");
    }
}
