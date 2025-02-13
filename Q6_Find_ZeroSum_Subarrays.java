import java.util.*;

class ZeroSumSubarrays {
    public List<int[]> findZeroSumSubarrays(int[] nums) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        map.put(0, new ArrayList<>(Arrays.asList(-1)));
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    result.add(new int[]{start + 1, i});
                }
            }
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        return result;
    }
}

public class Q6_Find_ZeroSum_Subarrays {
    public static void main(String[] args) {
        ZeroSumSubarrays zss = new ZeroSumSubarrays();
        int[] nums = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        List<int[]> result = zss.findZeroSumSubarrays(nums);
        for (int[] subarray : result) {
            System.out.println("Subarray found from index " + subarray[0] + " to " + subarray[1]);
        }
    }
}
