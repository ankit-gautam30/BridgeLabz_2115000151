import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        // Take user input for temperature and conversion type
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();
        
        System.out.print("Convert to (C)elsius or (F)ahrenheit? ");
        char choice = scanner.next().toUpperCase().charAt(0);
        
        // Perform conversion based on user choice
        if (choice == 'C') {
            double celsius = fahrenheitToCelsius(temperature);
            System.out.println(temperature + " Fahrenheit is " + celsius + " Celsius.");
        } else if (choice == 'F') {
            double fahrenheit = celsiusToFahrenheit(temperature);
            System.out.println(temperature + " Celsius is " + fahrenheit + " Fahrenheit.");
        } else {
            System.out.println("Invalid choice. Please enter 'C' or 'F'.");
        }
        
        scanner.close();
    }

    // Function to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Function to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}
