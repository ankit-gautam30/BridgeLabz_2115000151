import java.util.Scanner;

public class IntOperations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
	System.out.print("a :");
        int a = input.nextInt();
	System.out.print("b :");
        int b = input.nextInt();
	System.out.print("c :");
        int c = input.nextInt();

        int result1 = a + b * c;
        int result2 = a * b + c;
        int result3 = c + a / b;
        int result4 = a % b + c;

        System.out.println("The results of Int Operations are " + result1 + ", " + result2 + ", and " + result3 + ", " + result4);
    }
}
