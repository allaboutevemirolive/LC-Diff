public class B0055_ReverseOrder {
    /**
     * Iterating in REVERSE order
     * 
     * HINT : each element in the array REPRESENTS your MAXIMUM JUMP length at that position.
     * 
     * This method checks if it is possible to reach the last index of an input array by jumping from index to index.
     * @param nums the input array of integers
     * @return true if it is possible to reach the last index, false otherwise
     */
    public boolean canJump(int[] nums) {
        // Initialize lastPos as the last index of the input array
        int lastPos = nums.length - 1;
        // Iterate through the array in reverse order
        for (int i = nums.length - 2; i >= 0; i--) {
            // Check if the current index plus its value is greater or equal to the lastPos
            if (i + nums[i] >= lastPos) {
                // If true, update lastPos as the current index
                lastPos = i;
            }
        }
        // Check if the lastPos is the first index of the array
        return lastPos == 0;
    }
}
