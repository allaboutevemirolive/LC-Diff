public class D0055_AscendingOrder {
    /**
     * Iterating in ASCENDING order
     * This method checks if it is possible to reach the last index of an input array by jumping from index to index.
     * @param nums the input array of integers
     * @return true if it is possible to reach the last index, false otherwise
     */
    public boolean canJump(int[] nums) {
        // Initialize furthest as the first index of the input array
        int furthest = 0;
        // Iterate through the array in ascending order
        for (int i = 0; i < nums.length; i++) {
            // Check if the current index is less than or equal to the furthest index that can be reached
            if (i <= furthest) {
                // Update furthest as the maximum of the current furthest and the current index plus its value
                furthest = Math.max(furthest, i + nums[i]);
                // Check if the furthest index is greater than or equal to the last index of the array
                if (furthest >= nums.length - 1) {
                    // If true, return true
                    return true;
                }
            }
        }
        // If the loop completes, return false
        return false;
    }
}
