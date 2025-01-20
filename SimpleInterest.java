import java.util.Scanner;
public class SimpleInterest {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter principal: ");
		double Principal = scanner.nextDouble();
		System.out.print("Enter rate: ");
		double Rate = scanner.nextDouble();
		System.out.print("Enter time: ");
		int Time = scanner.nextInt();
		double SimpleInterest = (Principal * Rate * Time) / 100;
		System.out.println("The simple interest is: " + SimpleInterest);
	}
}