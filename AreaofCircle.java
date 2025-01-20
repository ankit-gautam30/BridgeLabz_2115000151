import java.util.Scanner;
public class AreaofCircle {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter radius of circle: ");
		double pi =3.142;
		double radius = scanner.nextDouble();
		double Area = pi * radius * radius;
		System.out.println("Area of circle: " + Area);
	}
}