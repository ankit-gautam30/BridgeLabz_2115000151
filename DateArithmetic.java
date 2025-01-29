import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateArithmetic {

    public static void main(String[] args) {
        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        // Ask user for a date input in "yyyy-MM-dd" format
        System.out.print("Enter a date (yyyy-MM-dd): ");
        String inputDate = scanner.nextLine();
        
        // Define a date formatter to parse the input date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        // Parse the input date to LocalDate
        LocalDate date = LocalDate.parse(inputDate, formatter);
        
        // Perform the date arithmetic:
        // Add 7 days, 1 month, and 2 years
        LocalDate newDate = date.plusDays(7)
                                .plusMonths(1)
                                .plusYears(2);
        
        // Subtract 3 weeks from the result
        newDate = newDate.minusWeeks(3);
        
        // Print the original and the modified date
        System.out.println("Original date: " + date);
        System.out.println("Modified date: " + newDate);
        
        // Close the scanner
        scanner.close();
    }
}
