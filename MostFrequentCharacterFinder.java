import java.util.Scanner;

public class MostFrequentCharacterFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();
        
        int[] charCounts = new int[256];
        for (char ch : input.toCharArray()) {
            charCounts[ch]++;
        }
        
        char mostFrequentChar = input.charAt(0);
        int maxCount = 0;
        
        for (char ch : input.toCharArray()) {
            if (charCounts[ch] > maxCount) {
                maxCount = charCounts[ch];
                mostFrequentChar = ch;
            }
        }
        
        System.out.println("Most Frequent Character: '" + mostFrequentChar + "'");
    }
}
