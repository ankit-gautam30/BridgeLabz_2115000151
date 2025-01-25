import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                if (numbers[i] % 2 == 0) {
                    System.out.println(numbers[i] + " is a positive even number.");
                } else {
                    System.out.println(numbers[i] + " is a positive odd number.");
                }
            } else if (numbers[i] < 0) {
                System.out.println(numbers[i] + " is a negative number.");
            } else {
                System.out.println(numbers[i] + " is zero.");
            }
        }

        if (numbers[0] > numbers[4]) {
            System.out.println("The first element is greater than the last element.");
        } else if (numbers[0] < numbers[4]) {
            System.out.println("The first element is less than the last element.");
        } else {
            System.out.println("The first and last elements are equal.");
        }

        scanner.close();
    }
}
