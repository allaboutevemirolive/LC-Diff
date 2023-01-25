import java.util.Arrays;

public class B0016 {
    
    public static int threeSumClosest(int[] nums, int t) {
        // Sort the array using a more efficient sorting algorithm (e.g. quicksort or merge sort)
        Arrays.sort(nums);

        // Initialize variables to track the minimum sum and its corresponding absolute difference from the target value
        int minSum = Integer.MAX_VALUE;
        int minAbs = Integer.MAX_VALUE;

        // Use a single loop to iterate over the elements of the array
        for (int i = 0; i < nums.length - 2; i++) {
            // Use two pointers to find the two elements that sum to the target value
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == t) {
                    // Return the sum if it is equal to the target value
                    return sum;
                } else if (sum > t) {
                    // Decrement the right pointer if the sum is greater than the target value
                    k--;
                } else {
                    // Increment the left pointer if the sum is less than the target value
                    j++;
                }

                // Update the minimum sum and its absolute difference from the target value if the current sum is closer to the target value
                int abs = Math.abs(sum - t);
                if (abs < minAbs) {
                    minAbs = abs;
                    minSum = sum;
                }
            }
        }

        // Return the minimum sum
        return minSum;
    }
}
