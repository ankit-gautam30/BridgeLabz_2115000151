import java.util.Scanner;

public class QuotientAndRemainder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
	System.out.print("The first number is: ");
        int number1 = input.nextInt();
	System.out.print("The second number is: ");
        int number2 = input.nextInt();

        int quotient = number1 / number2;
        int remainder = number1 % number2;

        System.out.println("The Quotient is " + quotient + " and Reminder is " + remainder + " of two numbers " + number1 + " and " + number2);
    }
}
