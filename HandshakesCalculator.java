import java.util.Scanner;

public class HandshakesCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
	System.out.print("The number of students is : ");
        int numberOfStudents = input.nextInt();
        
        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

        System.out.println("The maximum number of handshakes among " + numberOfStudents + " students is " + handshakes);
    }
}
