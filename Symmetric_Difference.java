import java.util.*;

public class Symmetric_Difference {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));
        
        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        
        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        
        Set<Integer> symmetricDifference = new HashSet<>(unionSet);
        symmetricDifference.removeAll(intersectionSet);
        
        System.out.println("Union: " + unionSet);
        System.out.println("Intersection: " + intersectionSet);
        System.out.println("Symmetric Difference: " + symmetricDifference);
    }
}
