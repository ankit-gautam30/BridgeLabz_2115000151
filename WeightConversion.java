import java.util.Scanner;

public class WeightConversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking user input for weight in pounds
        System.out.print("Enter the weight in pounds: ");
        double weightInPounds = input.nextDouble();

        // Conversion factor from pounds to kilograms
        double weightInKg = weightInPounds * 2.2;

        // Displaying the result
        System.out.println("The weight of the person in pound is " + weightInPounds + " and in kg is " + weightInKg);
    }
}
