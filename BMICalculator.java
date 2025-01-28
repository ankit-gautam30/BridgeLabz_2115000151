import java.util.Scanner;

public class BMICalculator {

    // Method to calculate BMI for all team members and populate the array
    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightInMeters = data[i][1] / 100.0; // Convert height from cm to meters
            data[i][2] = weight / (heightInMeters * heightInMeters); // BMI formula
        }
    }

    // Method to determine BMI status for each person
    public static String[] determineBMIStatus(double[][] data) {
        String[] statuses = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi <= 18.4) {
                statuses[i] = "Underweight";
            } else if (bmi <= 24.9) {
                statuses[i] = "Normal";
            } else if (bmi <= 39.9) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }
        return statuses;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] teamData = new double[10][3]; // 10 rows for team members, 3 columns for weight, height, and BMI

        // Input weight and height for each team member
        for (int i = 0; i < teamData.length; i++) {
            System.out.print("Enter weight (in kg) of team member " + (i + 1) + ": ");
            teamData[i][0] = scanner.nextDouble();
            System.out.print("Enter height (in cm) of team member " + (i + 1) + ": ");
            teamData[i][1] = scanner.nextDouble();
        }

        // Calculate BMI for all team members
        calculateBMI(teamData);

        // Determine BMI statuses
        String[] statuses = determineBMIStatus(teamData);

        // Display the results
        System.out.println("\nTeam Member Details:");
        System.out.println("---------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Weight(kg)", "Height(cm)", "BMI", "Status");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < teamData.length; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s\n", teamData[i][0], teamData[i][1], teamData[i][2], statuses[i]);
        }

        scanner.close();
    }
}
