import java.util.Scanner;
public class Average {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter first number: ");
		int num1 = scanner.nextInt();
		System.out.print("Enter second number: ");
		int num2 = scanner.nextInt();
		System.out.print("Enter third number: ");
		int num3 = scanner.nextInt();
		int sum = num1 + num2 + num3;
		double Average = sum / 3;
		System.out.println("The Average of three numbers is: " + Average);
		scanner.close();
	}
}