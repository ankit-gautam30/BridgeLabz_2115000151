import java.util.Scanner;

public class ToggleCaseConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();
        
        char[] toggledArray = new char[input.length()];
        
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isUpperCase(ch)) {
                toggledArray[i] = Character.toLowerCase(ch);
            } else if (Character.isLowerCase(ch)) {
                toggledArray[i] = Character.toUpperCase(ch);
            } else {
                toggledArray[i] = ch;
            }
        }
        
        String toggledString = new String(toggledArray);
        System.out.println("Toggled case string: " + toggledString);
    }
}

