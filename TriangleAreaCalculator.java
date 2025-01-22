import java.util.Scanner;

public class TriangleAreaCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
	System.out.print("The base of triangle is: ");
        double base = input.nextDouble();
	System.out.print("The height of triangle is: ");
        double height = input.nextDouble();

        double areaInSquareCm = 0.5 * base * height;
        double areaInSquareInches = areaInSquareCm / 6.4516;

        System.out.println("The area of the triangle is " + areaInSquareCm + " square centimeters and " 
                + areaInSquareInches + " square inches.");
    }
}
