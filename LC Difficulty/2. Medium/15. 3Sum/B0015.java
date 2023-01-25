import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B0015 {
    
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        // Sort the array in ascending order
        Arrays.sort(nums);

        // Fix the first element, and find the other two elements using two pointers
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Set the two pointers to the next elements after i
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // Skip duplicate second and third elements
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }

                    // Move the two pointers to the next elements
                    j++;
                    k--;
                } else if (sum < 0) {
                    // The sum is too small, move the second pointer to the next element
                    j++;
                } else {
                    // The sum is too large, move the third pointer to the previous element
                    k--;
                }
            }
        }

        return result;
    }
}
