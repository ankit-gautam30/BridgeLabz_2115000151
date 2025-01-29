import java.util.Scanner;

public class RemoveDuplicateCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();
        
        StringBuilder result = new StringBuilder();
        boolean[] seen = new boolean[256];
        
        for (char ch : input.toCharArray()) {
            if (!seen[ch]) {
                result.append(ch);
                seen[ch] = true;
            }
        }
        
        System.out.println("Modified string without duplicates: " + result.toString());
    }
}
