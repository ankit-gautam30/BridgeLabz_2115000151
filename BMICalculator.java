import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int numPersons = scanner.nextInt();

        if (numPersons <= 0) {
            System.out.println("Error: Number of persons must be a positive integer.");
            return;
        }

        double[] heights = new double[numPersons];
        double[] weights = new double[numPersons];
        double[] bmis = new double[numPersons];
        String[] statuses = new String[numPersons];

        for (int i = 0; i < numPersons; i++) {
            System.out.println("Enter details for person " + (i + 1) + ":");

            while (true) {
                System.out.print("Height (in meters): ");
                heights[i] = scanner.nextDouble();
                if (heights[i] <= 0) {
                    System.out.println("Error: Height must be a positive number. Please re-enter.");
                } else {
                    break;
                }
            }

            while (true) {
                System.out.print("Weight (in kilograms): ");
                weights[i] = scanner.nextDouble();
                if (weights[i] <= 0) {
                    System.out.println("Error: Weight must be a positive number. Please re-enter.");
                } else {
                    break;
                }
            }

            bmis[i] = weights[i] / (heights[i] * heights[i]);

            if (bmis[i] <= 18.4) {
                statuses[i] = "Underweight";
            } else if (bmis[i] <= 24.9) {
                statuses[i] = "Normal weight";
            } else if (bmis[i] <= 39.9) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obesity";
            }
        }

        System.out.println("\nResults:");
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Height(m)", "Weight(kg)", "BMI", "Status");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s\n", heights[i], weights[i], bmis[i], statuses[i]);
        }

        scanner.close();
    }
}
