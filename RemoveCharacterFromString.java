import java.util.Scanner;

public class RemoveCharacterFromString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.print("Enter the character to remove: ");
        char charToRemove = scanner.next().charAt(0);
        scanner.close();
        
        char[] modifiedArray = new char[input.length()];
        int index = 0;
        
        for (char ch : input.toCharArray()) {
            if (ch != charToRemove) {
                modifiedArray[index++] = ch;
            }
        }
        
        String modifiedString = new String(modifiedArray, 0, index);
        System.out.println("Modified String: " + modifiedString);
    }
}

