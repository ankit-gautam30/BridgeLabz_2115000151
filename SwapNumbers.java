import java.util.Scanner;

public class SwapNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
	System.out.print("The first number is : ");
        int number1 = input.nextInt();
	System.out.print("The second number is : ");
        int number2 = input.nextInt();

        // Swapping numbers
        int temp = number1;
        number1 = number2;
        number2 = temp;

        System.out.println("The swapped numbers are " + number1 + " and " + number2);
    }
}
