import java.util.Scanner;

public class TotalPriceCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
	System.out.print("The unit price of item is : ");
        double unitPrice = input.nextDouble();
	 System.out.print("The quantity of item is : ");
        int quantity = input.nextInt();

        double totalPrice = unitPrice * quantity;

        System.out.println("The total purchase price is INR " + totalPrice + " if the quantity is " 
                + quantity + " and unit price is INR " + unitPrice);
    }
}
