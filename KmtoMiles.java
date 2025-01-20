import java.util.Scanner;
public class KmtoMiles {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter distance in kilometers: ");
		double Kilometers = scanner.nextDouble();
		double Miles = Kilometers * 0.621371;
		System.out.println("The distance in Miles is: " + Miles);
	}
}