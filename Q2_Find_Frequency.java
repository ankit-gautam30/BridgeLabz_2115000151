import java.util.*;

public class Q2_Find_Frequency {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> frequencyMap = countFrequency(words);
        System.out.println(frequencyMap);
    }
    
    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : list) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }
}
