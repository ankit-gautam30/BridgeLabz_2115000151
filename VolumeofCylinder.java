import java.util.Scanner;
public class VolumeofCylinder {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter radius of cylinder: ");
		double pi =3.142;
		double radius = scanner.nextDouble();
		System.out.print("Enter height of cylinder: ");
		double height = scanner.nextDouble();
		double volume = pi * radius * radius * height;
		System.out.println("Volume of cylinder: " + volume);
	}
}