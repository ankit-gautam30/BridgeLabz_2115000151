import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] studentAges = {12, 15, 10, 18, 14, 13, 12, 17, 11, 16, 10};
        studentAges = countingSort(studentAges, 10, 18);
        System.out.println("Sorted Student Ages: " + Arrays.toString(studentAges));
    }

    public static int[] countingSort(int[] arr, int min, int max) {
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];
        
        for (int num : arr) {
            count[num - min]++;
        }
        
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        
        return output;
    }
}
