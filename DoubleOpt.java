import java.util.Scanner;

public class DoubleOpt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
	System.out.print("a :");
        double a = input.nextDouble();
	System.out.print("b :");
        double b = input.nextDouble();
	System.out.print("c :");
        double c = input.nextDouble();

        double result1 = a + b * c;
        double result2 = a * b + c;
        double result3 = c + a / b;
        double result4 = a % b + c;

        System.out.println("The results of Double Operations are " + result1 + ", " + result2 + ", and " + result3 + ", " + result4);
    }
}
