import java.util.Scanner;
public class PerimeterofReactangle {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter length of rectangle: ");
		double length = scanner.nextDouble();
		System.out.print("Enter breadth of rectangle: ");
		double breadth = scanner.nextDouble();
		double Perimeter = (length + breadth) * 2;
		System.out.println("Perimeter of Rectangle: " + Perimeter);
	}
}