import java.util.InputMismatchException;
import java.util.Scanner;

public class Q9_Example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {10, 20, 30, 40, 50};
        
        try {
            System.out.print("Enter the index: ");
            int index = scanner.nextInt();
            
            try {
                System.out.print("Enter the divisor: ");
                int divisor = scanner.nextInt();
                
                int result = array[index] / divisor;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid numeric value.");
        } finally {
            System.out.println("Operation completed");
            scanner.close();
        }
    }
}
