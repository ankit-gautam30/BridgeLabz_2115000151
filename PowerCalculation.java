import java.util.Scanner;
public class PowerCalculation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter first number as base: ");
		double base = scanner.nextDouble();
		System.out.print("Enter second number as exponent: ");
		double exponent = scanner.nextDouble();
		double result = Math.pow(base, exponent);
		System.out.println("The result of power calculation is: " + result);
		scanner.close();
	}
}