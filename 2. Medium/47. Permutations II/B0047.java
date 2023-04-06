import java.util.ArrayList;
import java.util.List;

public class B0047 {
    
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        permuteUnique(nums, 0, permutations);
        return permutations;
    }

    private static void permuteUnique(int[] nums, int index, List<List<Integer>> permutations) {
        if (index == nums.length) {
            permutations.add(toList(nums));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (shouldSwap(nums, index, i)) {
                swap(nums, index, i);
                permuteUnique(nums, index + 1, permutations);
                swap(nums, index, i);
            }
        }
    }

    private static boolean shouldSwap(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] == nums[end]) {
                return false;
            }
        }
        return true;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static List<Integer> toList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }
}
