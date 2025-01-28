import java.util.Scanner;

public class FriendComparison {

    // Method to find the youngest friend
    public static String findYoungest(String[] names, int[] ages) {
        int minAge = ages[0];
        String youngest = names[0];
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < minAge) {
                minAge = ages[i];
                youngest = names[i];
            }
        }
        return youngest;
    }

    // Method to find the tallest friend
    public static String findTallest(String[] names, double[] heights) {
        double maxHeight = heights[0];
        String tallest = names[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                tallest = names[i];
            }
        }
        return tallest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Input ages and heights for the friends
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter the age of " + names[i] + ": ");
            ages[i] = scanner.nextInt();
            System.out.print("Enter the height (in cm) of " + names[i] + ": ");
            heights[i] = scanner.nextDouble();
        }

        // Find and display the youngest and tallest friends
        String youngest = findYoungest(names, ages);
        String tallest = findTallest(names, heights);

        System.out.println("The youngest friend is: " + youngest);
        System.out.println("The tallest friend is: " + tallest);

        scanner.close();
    }
}
