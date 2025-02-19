import java.util.*;

public class ListRotator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int positions = 2;
        rotateList(list, positions);
        System.out.println(list);
    }
    
    public static void rotateList(List<Integer> list, int positions) {
        int size = list.size();
        positions = positions % size;
        List<Integer> rotated = new ArrayList<>(list.subList(positions, size));
        rotated.addAll(list.subList(0, positions));
        list.clear();
        list.addAll(rotated);
    }
}
