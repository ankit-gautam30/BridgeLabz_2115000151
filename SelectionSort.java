import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        double[] examScores = {85.5, 92.0, 76.5, 88.0, 90.5, 79.0};
        selectionSort(examScores);
        System.out.println("Sorted Exam Scores: " + Arrays.toString(examScores));
    }

    public static void selectionSort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
