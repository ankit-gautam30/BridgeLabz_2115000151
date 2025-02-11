import java.util.*;

class TextState {
    String content;
    TextState next, prev;

    public TextState(String content) {
        this.content = content;
        this.next = null;
        this.prev = null;
    }
}

class TextEditor {
    private TextState head, current;
    private int maxHistory;

    public TextEditor(int maxHistory) {
        this.head = null;
        this.current = null;
        this.maxHistory = maxHistory;
    }

    public void addState(String content) {
        TextState newState = new TextState(content);
        if (head == null) {
            head = newState;
            current = newState;
        } else {
            current.next = newState;
            newState.prev = current;
            current = newState;
        }
        trimHistory();
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.content);
        } else {
            System.out.println("No text available.");
        }
    }

    private void trimHistory() {
        int count = 0;
        TextState temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        if (count > maxHistory) {
            head = head.next;
            head.prev = null;
        }
    }
}

public class Q8_Undo_Redo_Text_Editor {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.redo();
        editor.displayCurrentState();
    }
}

