import java.util.Scanner;

public class ChocolateDivision {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking user inputs for the number of chocolates and children
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = input.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = input.nextInt();

        // Calculating how many chocolates each child gets and the remaining chocolates
        int chocolatesPerChild = numberOfChocolates / numberOfChildren;
        int remainingChocolates = numberOfChocolates % numberOfChildren;

        // Displaying the results
        System.out.println("The number of chocolates each child gets is " + chocolatesPerChild + 
                           " and the number of remaining chocolates are " + remainingChocolates);
    }
}
