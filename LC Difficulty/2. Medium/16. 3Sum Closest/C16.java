import java.util.Arrays;

class C16 {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the input array nums to make use of the two pointer solution
        Arrays.sort(nums);

        // Assume the minimum value to be the sum of the first three elements in the sorted array
        int closestSum = nums[0] + nums[1] + nums[2];

        // Iterate through the array nums
        for (int i = 0; i < nums.length; i++) {
            // Set the start and end pointers
            int start = i + 1;
            int end = nums.length - 1;

            // Use the two pointer approach to find the sum of three numbers that is closest to target
            while (start < end) {
                int currentSum = nums[i] + nums[start] + nums[end];

                // If the difference between the target and the current sum is less than the difference between the target and the closest sum, update the closest sum
                if (Math.abs(target - closestSum) > Math.abs(target - currentSum)) {
                    closestSum = currentSum;
                }

                // Increment or decrement the pointers based on the current sum relative to the target
                if (currentSum > target) {
                    end--;
                } else if (currentSum < target) {
                    start++;
                } else {
                    // If the current sum is equal to the target, return the target
                    return target;
                }
            }
        }
        // Return the closest sum found
        return closestSum;
    }   
}
