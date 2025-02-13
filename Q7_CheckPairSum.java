import java.util.*;

class PairWithGivenSum {
    public boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(target - num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}

public class Q7_CheckPairSum {
    public static void main(String[] args) {
        PairWithGivenSum checker = new PairWithGivenSum();
        int[] nums = {1, 4, 6, 8, 10};
        int target = 14;
        System.out.println(checker.hasPairWithSum(nums, target));
    }
}
