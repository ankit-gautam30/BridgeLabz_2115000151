import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] marks = {78, 92, 45, 88, 67, 99, 54};
        
        for (int i = 0; i < marks.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < marks.length - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
       
        System.out.println("Sorted Marks: " + Arrays.toString(marks));
    }
}
