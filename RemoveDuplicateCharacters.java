import java.util.Scanner;

public class RemoveDuplicateCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();
        
        boolean[] seen = new boolean[256];
        char[] resultArray = new char[input.length()];
        int index = 0;
        
        for (char ch : input.toCharArray()) {
            if (!seen[ch]) {
                resultArray[index++] = ch;
                seen[ch] = true;
            }
        }
        
        String result = new String(resultArray, 0, index);
        System.out.println("Modified string without duplicates: " + result);
    }
}

