import java.util.Random;

public class EmployeeBonus {

    // Method to generate random salary and years of service for each employee
    public static double[][] generateEmployeeData(int numEmployees) {
        Random random = new Random();
        double[][] employeeData = new double[numEmployees][2]; // [][0] = salary, [][1] = years of service

        for (int i = 0; i < numEmployees; i++) {
            // Generate random 5-digit salary (between 10000 and 99999)
            employeeData[i][0] = 10000 + random.nextInt(90000); 
            // Generate random years of service (between 1 and 20 years)
            employeeData[i][1] = 1 + random.nextInt(20); 
        }

        return employeeData;
    }

    // Method to calculate the new salary and bonus for each employee
    public static double[][] calculateNewSalaryAndBonus(double[][] employeeData) {
        double[][] updatedData = new double[employeeData.length][3]; // [][0] = old salary, [][1] = new salary, [][2] = bonus

        for (int i = 0; i < employeeData.length; i++) {
            double oldSalary = employeeData[i][0];
            double yearsOfService = employeeData[i][1];

            // Calculate bonus
            double bonus = 0;
            if (yearsOfService > 5) {
                bonus = 0.05 * oldSalary; // 5% bonus for service more than 5 years
            } else {
                bonus = 0.02 * oldSalary; // 2% bonus for service less than or equal to 5 years
            }

            // Calculate new salary
            double newSalary = oldSalary + bonus;

            // Store old salary, new salary, and bonus in updatedData
            updatedData[i][0] = oldSalary;
            updatedData[i][1] = newSalary;
            updatedData[i][2] = bonus;
        }

        return updatedData;
    }

    // Method to calculate and display the sum of old salaries, new salaries, and total bonuses
    public static void displayResults(double[][] updatedData) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        // Display headers
        System.out.println("---------------------------------------------------------------");
        System.out.printf("| %-10s | %-12s | %-12s | %-10s |\n", "Employee", "Old Salary", "New Salary", "Bonus");
        System.out.println("---------------------------------------------------------------");

        // Display employee details and accumulate totals
        for (int i = 0; i < updatedData.length; i++) {
            double oldSalary = updatedData[i][0];
            double newSalary = updatedData[i][1];
            double bonus = updatedData[i][2];

            System.out.printf("| %-10d | %-12.2f | %-12.2f | %-10.2f |\n", (i + 1), oldSalary, newSalary, bonus);

            totalOldSalary += oldSalary;
            totalNewSalary += newSalary;
            totalBonus += bonus;
        }

        System.out.println("---------------------------------------------------------------");
        System.out.printf("| %-10s | %-12.2f | %-12.2f | %-10.2f |\n", "Total", totalOldSalary, totalNewSalary, totalBonus);
        System.out.println("---------------------------------------------------------------");
    }

    public static void main(String[] args) {
        // Number of employees
        int numEmployees = 10;

        // Step 1: Generate random salary and years of service for each employee
        double[][] employeeData = generateEmployeeData(numEmployees);

        // Step 2: Calculate new salary and bonus for each employee
        double[][] updatedData = calculateNewSalaryAndBonus(employeeData);

        // Step 3: Display results in a tabular format
        displayResults(updatedData);
    }
}
