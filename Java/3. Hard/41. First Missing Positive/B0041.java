public class B0041 {

    public static int firstMissingPositive(int[] nums) {
        // Place each number in its correct position
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0 && num <= nums.length && num != nums[num - 1]) {
                // Swap nums[i] with nums[num - 1]
                nums[i] = nums[num - 1];
                nums[num - 1] = num;
                i--; // repeat the current iteration with the updated nums[i]
            }
        }

        // Find the first missing positive integer
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // All numbers from 1 to nums.length are present
        return nums.length + 1;
    }

}
