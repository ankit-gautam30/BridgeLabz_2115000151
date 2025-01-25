import java.util.Scanner;

public class YoungestAndTallest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] friends = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < friends.length; i++) {
            System.out.println("Enter details for " + friends[i] + ":");

            while (true) {
                System.out.print("Age: ");
                ages[i] = scanner.nextInt();
                if (ages[i] <= 0) {
                    System.out.println("Error: Age must be a positive number. Please re-enter.");
                } else {
                    break;
                }
            }

            while (true) {
                System.out.print("Height (in cm): ");
                heights[i] = scanner.nextDouble();
                if (heights[i] <= 0) {
                    System.out.println("Error: Height must be a positive number. Please re-enter.");
                } else {
                    break;
                }
            }
        }

        int youngestIndex = 0;
        double tallestIndex = 0;

        for (int i = 1; i < friends.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[(int) tallestIndex]) {
                tallestIndex = i;
            }
        }

        System.out.println("\nResults:");
        System.out.println("The youngest friend is " + friends[youngestIndex] + " with an age of " + ages[youngestIndex] + ".");
        System.out.println("The tallest friend is " + friends[(int) tallestIndex] + " with a height of " + heights[(int) tallestIndex] + " cm.");

        scanner.close();
    }
}
