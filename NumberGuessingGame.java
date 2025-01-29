import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int low = 1;
        int high = 100;
        boolean isGuessed = false;
        
        System.out.println("Think of a number between 1 and 100, and I'll try to guess it.");
        
        while (!isGuessed) {
            int guess = generateGuess(low, high);
            System.out.println("Is the number " + guess + "? (Enter 'high', 'low', or 'correct')");
            String feedback = scanner.nextLine().toLowerCase();
            
            isGuessed = processFeedback(feedback, guess, low, high);
        }
        
        System.out.println("Yay! I guessed your number!");
        scanner.close();
    }

    public static int generateGuess(int low, int high) {
        Random random = new Random();
        return random.nextInt(high - low + 1) + low;
    }

    public static boolean processFeedback(String feedback, int guess, int low, int high) {
        if (feedback.equals("correct")) {
            return true;
        } else if (feedback.equals("high")) {
            high = guess - 1;
        } else if (feedback.equals("low")) {
            low = guess + 1;
        }
        return false;
    }
}
