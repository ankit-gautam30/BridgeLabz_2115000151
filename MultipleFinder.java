import java.util.Scanner;

public class MultipleFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	System.out.print("The number is : ");
        int number = scanner.nextInt();

        for (int i = 100; i >= 1; i--) {
            if (i % number == 0) {
                System.out.println(i);
            }
        }
    }
}
