import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
	System.out.print("The temperature in celsius is :");
        double celsius = input.nextDouble();
        double fahrenheitResult = (celsius * 9/5) + 32;

        System.out.println("The " + celsius + " celsius is " + fahrenheitResult + " fahrenheit");
    }
}
