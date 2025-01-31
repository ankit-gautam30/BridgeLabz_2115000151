import java.util.Scanner;
class Circle{
	private double radius;

	public Circle(double radius){
		this.radius = radius;
	}
	public double calculateArea() {
		return Math.PI * radius * radius;
	}
	public double calculateCircumference() {
		return 2 * Math.PI * radius;
	}

	public void displayDetails() {
		System.out.println("Circle Details:");
		System.out.println("Radius of Circle:" + radius);
		System.out.println("Area of Circle:" + calculateArea());
		System.out.println("Circumference of Circle:" + calculateCircumference());
	}

	public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	System.out.print("Enter the radius of circle:");
	double radius = input.nextDouble();
	Circle circle = new Circle(radius);
	circle.displayDetails();
	input.close();
	}
}
