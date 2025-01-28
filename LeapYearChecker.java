import java.util.Scanner;

public class LeapYearChecker {

    // Method to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        // Condition for a year to be a leap year
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for the year
        System.out.print("Enter a year (>= 1582): ");
        int year = scanner.nextInt();

        // Check if the year is valid (Gregorian calendar starts from 1582)
        if (year < 1582) {
            System.out.println("The year must be 1582 or later. Please enter a valid year.");
        } else {
            // Check if the year is a leap year
            if (isLeapYear(year)) {
                System.out.println(year + " is a Leap Year.");
            } else {
                System.out.println(year + " is not a Leap Year.");
            }
        }

        scanner.close();
    }
}
