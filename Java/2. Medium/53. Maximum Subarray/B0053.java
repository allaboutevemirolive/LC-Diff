class B0053 {
    public int maxSubArray(int[] nums) {
        // Initialize maxSum to the lowest possible value for an integer
        int maxSum = Integer.MIN_VALUE;
        // Initialize currentSum to keep track of the current sum
        int currentSum = 0;
        // Iterate through the array of integers
        for (int num : nums) {
            // Update currentSum by taking the maximum of the current value or the currentSum + current value
            currentSum = Math.max(num, currentSum + num);
            // Update maxSum by taking the maximum of the current maxSum or currentSum
            maxSum = Math.max(maxSum, currentSum);
        }
        // Return the maximum sum of the subarray
        return maxSum;
    }
}
