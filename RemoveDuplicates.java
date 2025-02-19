import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 2, 2, 3, 4));
        removeDuplicates(list);
        System.out.println(list);
    }
    
    public static void removeDuplicates(List<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> uniqueList = new ArrayList<>();
        for (Integer num : list) {
            if (seen.add(num)) {
                uniqueList.add(num);
            }
        }
        list.clear();
        list.addAll(uniqueList);
    }
}
