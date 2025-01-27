import java.util.Scanner;

public class WindChillCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input for temperature and wind speed
        System.out.print("Enter the temperature (in Fahrenheit): ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter the wind speed (in mph): ");
        double windSpeed = scanner.nextDouble();

        // Validate the input
        if (temperature > 50 || windSpeed < 3) {
            System.out.println("Wind chill calculation is not valid for temperature > 50°F or wind speed < 3 mph.");
        } else {
            // Calculate wind chill
            double windChill = calculateWindChill(temperature, windSpeed);

            // Display the result
            System.out.printf("The wind chill temperature is: %.2f°F%n", windChill);
        }

        scanner.close();
    }

    // Method to calculate the wind chill temperature
    public static double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }
}
