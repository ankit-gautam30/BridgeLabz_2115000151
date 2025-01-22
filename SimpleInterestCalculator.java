import java.util.Scanner;

public class SimpleInterestCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking user inputs for principal, rate, and time
        System.out.print("Enter the principal amount: ");
        double principal = input.nextDouble();

        System.out.print("Enter the rate of interest: ");
        double rate = input.nextDouble();

        System.out.print("Enter the time period (in years): ");
        double time = input.nextDouble();

        // Calculating Simple Interest
        double simpleInterest = (principal * rate * time) / 100;

        // Displaying the result
        System.out.println("The Simple Interest is " + simpleInterest + " for Principal " + principal +
                           ", Rate of Interest " + rate + " and Time " + time);
    }
}
