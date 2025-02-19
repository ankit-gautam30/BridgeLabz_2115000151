import java.io.*;
import java.util.*;

public class MaxValueKeyFinder {
    public static void main(String[] args) {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 10);
        inputMap.put("B", 20);
        inputMap.put("C", 15);
        
        String maxKey = findMaxKey(inputMap);
        System.out.println(maxKey);
    }

    public static String findMaxKey(Map<String, Integer> map) {
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
