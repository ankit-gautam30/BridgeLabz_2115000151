import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	System.out.print("Enter first number : ");
        double first = scanner.nextDouble();
	System.out.print("Enter second number : ");
        double second = scanner.nextDouble();
	System.out.print("Sign : ");
        String sign = scanner.next();

        switch (sign) {
            case "+":
                System.out.println(first + second);
                break;
            case "-":
                System.out.println(first - second);
                break;
            case "*":
                System.out.println(first * second);
                break;
            case "/":
                if (second != 0) {
                    System.out.println(first / second);
                } else {
                    System.out.println("Cannot divide by zero");
                }
                break;
            default:
                System.out.println("Invalid Operator");
                break;
        }
    }
}
